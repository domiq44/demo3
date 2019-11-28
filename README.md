
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

