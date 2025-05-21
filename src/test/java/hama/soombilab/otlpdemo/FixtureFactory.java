package hama.soombilab.otlpdemo;

import static com.navercorp.fixturemonkey.api.experimental.JavaGetterMethodPropertySelector.javaGetter;

import com.navercorp.fixturemonkey.ArbitraryBuilder;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.experimental.JavaGetterMethodReference;
import com.navercorp.fixturemonkey.api.introspector.BeanArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.BuilderArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.FailoverIntrospector;
import com.navercorp.fixturemonkey.api.introspector.FieldReflectionArbitraryIntrospector;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;

public final class FixtureFactory {

    public final static FixtureMonkey FIXTURE_MONKEY = FixtureMonkey.builder()
        .objectIntrospector(new FailoverIntrospector(
            List.of(
                BeanArbitraryIntrospector.INSTANCE,
                BuilderArbitraryIntrospector.INSTANCE,
                FieldReflectionArbitraryIntrospector.INSTANCE,
                ConstructorPropertiesArbitraryIntrospector.INSTANCE
            )))
        .defaultNotNull(true) // 설정되지 않은 필드는 null 이 아닌 랜덤값이 자동으로 할당된다.
        .build();

    public static <T> T createFixture(Class<T> clazz) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        return entityBuilder.sample();
    }

    public static <T> T createFixture(Class<T> clazz, Map<JavaGetterMethodReference<T, ?>, ?> getterToFieldValues) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        getterToFieldValues.forEach((getterMethodReference, fieldValue) ->
            entityBuilder.set(
                javaGetter(getterMethodReference),
                fieldValue
            )
        );
        return entityBuilder.sample();
    }

    @SafeVarargs
    public static <T> T createFixture(
        Class<T> clazz,
        Map<JavaGetterMethodReference<T, ?>, ?> getterToFieldValues,
        JavaGetterMethodReference<T, ?>... ignoreFields
    ) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        getterToFieldValues.forEach((getterMethodReference, fieldValue) ->
            entityBuilder.set(
                javaGetter(getterMethodReference),
                fieldValue
            )
        );
        Arrays.stream(ignoreFields).forEach(ignoreField ->
            entityBuilder.set(
                javaGetter(ignoreField),
                null
            )
        );
        return entityBuilder.sample();
    }

    public static <T> List<T> createFixtures(int size, Class<T> clazz) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        return entityBuilder.sampleList(size);
    }

    public static <T> List<T> createFixtures(int size, Class<T> clazz, Map<JavaGetterMethodReference<T, ?>, ?> getterToFieldValues) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        getterToFieldValues.forEach((getterMethodReference, fieldValue) ->
            entityBuilder.set(
                javaGetter(getterMethodReference),
                fieldValue
            )
        );
        return entityBuilder.sampleList(size);
    }

    @SafeVarargs
    public static <T> List<T> createFixtures(
        int size,
        Class<T> clazz,
        Map<JavaGetterMethodReference<T, ?>, ?> getterToFieldValues,
        JavaGetterMethodReference<T, ?>... ignoreFields
    ) {
        ArbitraryBuilder<T> entityBuilder = FixtureFactory.FIXTURE_MONKEY
            .giveMeBuilder(clazz);
        getterToFieldValues.forEach((getterMethodReference, fieldValue) ->
            entityBuilder.set(
                javaGetter(getterMethodReference),
                fieldValue
            )
        );
        Arrays.stream(ignoreFields).forEach(ignoreField ->
            entityBuilder.set(
                javaGetter(ignoreField),
                null
            )
        );
        return entityBuilder.sampleList(size);
    }
}
