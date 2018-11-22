package com.example.hiberate.jdk8.optional;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class OptionalService {
    public static void main(String[] args){
        Optional<Integer> optional1=Optional.of(6);
        Optional<Integer> optional2=Optional.ofNullable(null);
        Optional<Integer> optional3=Optional.ofNullable(3);
        Optional<Integer> optional4=Optional.empty();

        //isPresent()：判断值是否存在
        System.out.println(optional1.isPresent());
        System.out.println(optional2.isPresent());

        //ifPresent(Consumer consumer)：如果option对象保存的值不是null，则调用consumer对象，否则不调用
        optional1.ifPresent(System.out::println);
        optional2.ifPresent(System.out::println);

        //orElse(value)：如果optional对象保存的值不是null，则返回原来的值，否则返回value
        System.out.println(optional1.orElse(66));
        System.out.println(optional2.orElse(33));
        System.out.println(optional2.orElse(getInt()));

        //orElseGet(Supplier supplier)：功能与orElse一样，只不过orElseGet参数是一个对象
        System.out.println(optional1.orElseGet(() -> 666));
        System.out.println(optional2.orElseGet(() -> 333));

        //orElseThrow()：值不存在则抛出异常，存在则什么不做
        try {
            System.out.println(optional1.orElseThrow((Supplier<Throwable>) () -> new Exception("sss")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }
        try {
            System.out.println(optional2.orElseThrow((Supplier<Throwable>) () -> new Exception("sss")));
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());
        }

        //filter(Predicate)：判断Optional对象中保存的值是否满足Predicate，并返回新的Optional
        System.out.println(optional1.filter(integer -> false));
        System.out.println(optional1.filter(integer -> true));

        //map(Function)：对Optional中保存的值进行函数运算，并返回新的Optional(可以是任何类型)
        System.out.println(optional1.map((Function<Integer, Object>) integer -> "obj"+integer));
        System.out.println(optional1.map(a -> "key" + a));

        //flatMap()：功能与map()相似，差别请看如下代码。flatMap方法与map方法类似，区别在于mapping函数的返回值不同。
        // map方法的mapping函数返回值可以是任何类型T，而flatMap方法的mapping函数必须是Optional。
        System.out.println(optional1.flatMap(new Function<Integer, Optional<String>>() {
            @Override
            public Optional<String> apply(Integer integer) {
                return Optional.of("haha");
            }
        }));


    }

    public static Integer getInt(){
        return 33;
    }
}
