
# Speed up Spring Boot startup time

## Step 3

*Spring Boot project.*

Replace

    @EnableAutoConfiguration

in main application class by

    @ImportAutoConfiguration({
        ....
    })
    @EntityScan
    @EnableJpaRepositories
    @ComponentScan

In annotation **@ImportAutoConfiguration**, you have to list all AutoConfig classes the project need.

To know what project need, you can add in application.poroperties

    logging.level.org.springframework.boot.autoconfigure=debug

## Content

1. [demo1](https://github.com/domiq44/demo1)
2. [demo2](https://github.com/domiq44/demo2)
3. demo3
4. [demo4](https://github.com/domiq44/demo4)
5. [demo5](https://github.com/domiq44/demo5)
