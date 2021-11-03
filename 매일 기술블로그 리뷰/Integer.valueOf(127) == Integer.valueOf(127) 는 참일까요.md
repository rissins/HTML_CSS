# 매일 기술블로그 Review

# 2021-11-03

### / 링크

[[Java] Integer.valueOf(127) == Integer.valueOf(127) 는 참일까요? : NHN Cloud Meetup](https://meetup.toast.com/posts/185)

### / 정리

## Integer.valueOf(127) == Integer.valueOf(127) is true ???

```java
Integer a = 127;
Integer b = 127;

a == b (true ? false ?)
```

### 2개의 Integer의 객체가 있을 때   a == b 일까 ?

- int 리터럴을 Integer reference로 직접 대입하는 것은 auto-boxing 컨셉의 예
- 리터럴 값이 객체로 변환되는 코드는 컴파일러에 의해 수행되고, 컴파일 시간동안 컴파일러는 `Integer a =127;` 을  `Integer a = Integer.valueOf(127);` 로 변경한다.
- Integer 클래스는 내부에서 integer 사용을 위해 IntegerCache를 관리한다.
    - 이 캐시의 기본 범위는 -128 ~ 127 이며, `integer.valueOf( )` 메소드는 캐시 범위에 해당하는 objects를 리턴한다.
    - a 와 b는 둘다, 같은 object를 가르키게 되므로, **a == b 가 true** 가 된다.

### 2가지로 나뉘는 Java 타입

1. Primitive Types : 자바에는 8개의 primitive types(byte, short, int, long, float, double, char, boolean)이 있고, 이들은 binary bits 형식으로 그들 **값을 직접** 가지고 있다.
2. Reference Types : Classes, Interfaces, Enums, Arrays 등과 같은 primitive types가 아닌 모든 타입들은 Reference Type입니다. Reference Type은 "object" 그 자신을 가지는 것이 아니라, **"object address"** 를 가지고 있다.
    1. 예를 들어 `Integer a = new Integer(5); Integer  b = new Integer(5);` 가  있을 때, a와 b는 binary 값인 5를 가지고 있는 것이 아니라, 각각 5의 값을 가지고 있는 objects의 메모리 주소값을 있다.
    2. 그래서 a와 b를 a == b를 비교할 때는 사실 두 개의 메모리 주소를 비교하여 false를 얻는다.
    3.  a 와 b의 동치 비교를 할 때는 `a.equals(b)` 로 비교를 해야한다.
    

### Primitive types의 wrapper classes, auto-boxing — auto-unboxing

```java
Integer c = 128; // 컴파일러가 다음과 같이 변환 : Integer c = Integer.valueOf(128);
int e = c; //  컴파일러가 다음과 같이 변환 : int e = c.intValue();
```

- `a` 와 `b` integer 객체를 만들고, 비교 연산자 `==`로 비교하면 `false`값을  얻을 수 있다.
    - 각각 다른 object를 들고 있기 때문

```java
Integer a = 128; // Integer a = Integer.valueOf(128);
Integer b = 128; // Integer b = Integer.valueOf(128);

System.out.println(a == b);  // false

Integer c = 127; Integer a = Integer.valueOf(127);
Integer b = 127; Integer b = Integer.valueOf(127);

System.out.println(a == b);  // true
```

- `Integer a = 127;` 구문이 auto-boxing의 예 이고 컴파일러가 자동으로 `Integer a = Integer.valueOf(127);` 로 바꿔주는 것을 알고있다.
- `IntegerCache.low` 보다 크고 `IntegerCache.high` 보다 작은 int 리터럴 `i`를 넘긴다면, Integer.valueOf() 메소드는 `IntegerCache` 로부터 Integer 객체들을 리턴한다.
- **IntegerCache.low** 와 **IntegerCache.high** 의 기본값은 각각 `128`과 `127`이다.
    - 즉, Integer.valueOf() 메소드는 -128에서 127 사이의 int literal을 넘겨줄 때, 새로운 Integer 객체를 생성하고 리턴하는 대신, 내부의 IntegerCache 객체에서 Integer 객체를 반환한다.
    
    ```java
    public static Integer valueOf(int i) {
            if (i >= IntegerCache.low && i <= IntegerCache.high)
                return IntegerCache.cache[i + (-IntegerCache.low)];
            return new Integer(i);
        }
    ```
    
    ```java
    private static class IntegerCache {
            static final int low = -128;
            static final int high;
            static final Integer cache[];
    
            static {
                // high value may be configured by property
                int h = 127;
                String integerCacheHighPropValue =
                    sun.misc.VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
                if (integerCacheHighPropValue != null) {
                    try {
                        int i = parseInt(integerCacheHighPropValue);
                        i = Math.max(i, 127);
                        // Maximum array size is Integer.MAX_VALUE
                        h = Math.min(i, Integer.MAX_VALUE - (-low) -1);
                    } catch( NumberFormatException nfe) {
                        // If the property cannot be parsed into an int, ignore it.
                    }
                }
                high = h;
    
                cache = new Integer[(high - low) + 1];
                int j = low;
                for(int k = 0; k < cache.length; k++)
                    cache[k] = new Integer(j++);
    
                // range [-128, 127] must be interned (JLS7 5.1.7)
                assert IntegerCache.high >= 127;
            }
    
            private IntegerCache() {}
        }
    ```
    

- Byte, Short, Long 타입은 -127부터 127까지의(-127<=, <=127) 고정된 캐시값을 가진다
- Character는 0부터 127(0<=, <=127)까지의 고정된 캐시값을 가집니다.
- 범위를 수정하는 것은 Integer만 수정할 수 있으며, 다른 타입에는 수정이 불가능합니다.