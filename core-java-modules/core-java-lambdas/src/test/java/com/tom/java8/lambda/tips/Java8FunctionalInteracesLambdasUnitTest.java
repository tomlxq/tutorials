package com.tom.java8.lambda.tips;

import org.junit.Before;
import org.junit.Test;

import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class Java8FunctionalInteracesLambdasUnitTest {

    private UseFoo useFoo;

    @Before
    public void init() {
        useFoo = new UseFoo();
    }

    @Test
    public void functionalInterfaceInstantiation_whenReturnDefiniteString_thenCorrect() {
        final Foo foo = parameter -> parameter + "from lambda";
        final String result = useFoo.add("Message ", foo);

        assertEquals("Message from lambda", result);
    }

    @Test
    public void standardFIParameter_whenReturnDefiniteString_thenCorrect() {
        final Function<String, String> fn = parameter -> parameter + "from lambda";
        final String result = useFoo.addWithStandardFI("Message ", fn);

        assertEquals("Message from lambda", result);
    }

    @Test
    public void defaultMethodFromExtendedInterface_whenReturnDefiniteString_thenCorrect() {
        final FooExtended fooExtended = string -> string;
        final String result = fooExtended.defaultMethod();

        assertEquals("String from Bar", result);
    }

    @Test
    public void lambdaAndInnerClassInstantiation_whenReturnSameString_thenCorrect() {
        final Foo foo = parameter -> parameter + "from Foo";

        final Foo fooByIC = new Foo() {
            @Override
            public String method(final String string) {
                return string + "from Foo";
            }
        };

        assertEquals(foo.method("Something "), fooByIC.method("Something "));
    }

    @Test
    public void accessVariablesFromDifferentScopes_whenReturnPredefinedString_thenCorrect() {
        assertEquals("Results: resultIC = Inner class value, resultLambda = Enclosing scope value", useFoo.scopeExperiment());
    }

    @Test
    public void shorteningLambdas_whenReturnEqualsResults_thenCorrect() {
        final Foo foo = parameter -> buildString(parameter);

        final Foo fooHuge = parameter -> {
            final String result = "Something " + parameter;
            // many lines of code
            return result;
        };

        assertEquals(foo.method("Something"), fooHuge.method("Something"));
    }

    private String buildString(final String parameter) {
        final String result = "Something " + parameter;
        // many lines of code
        return result;
    }

    @Test
    public void mutatingOfEffectivelyFinalVariable_whenNotEquals_thenCorrect() {
        final int[] total = new int[1];
        final Runnable r = () -> total[0]++;
        r.run();

        assertNotEquals(0, total[0]);
    }

    @Test
    public void lambda_ambiguous_with_casting_type() {
        ProcessorFirst processor = new ProcessorImplFirst();
        String result = processor.process((Supplier<String>) () -> "abc");
        System.out.println(result);
    }

    @Test
    public void lambda_ambiguous_with_diff_method_name() {
        Processor processor = new ProcessorImpl();
        String result = processor.processWithSupplier(() -> "abc");
        System.out.println(result);
    }

    @Test
    public void lambda_specify_type() {
        ProcessorFirst processor = new ProcessorImplFirst();
        //final String result = processor.add((a, b) -> a.toLowerCase() + b.toLowerCase());
        //final String result2 = processor.add((String c, String d) -> c.toLowerCase() + d.toLowerCase());
    }
}