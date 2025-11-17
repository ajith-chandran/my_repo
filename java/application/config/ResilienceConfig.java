@Configuration
public class ResilienceConfig {

    @Bean
    public Customizer<Resilience4JCircuitBreakerFactory> cbFactory() {
        return factory -> factory.configureDefault(id ->
                new CircuitBreakerConfig.Builder()
                        .failureRateThreshold(50)
                        .waitDurationInOpenState(Duration.ofSeconds(10))
                        .build()
        );
    }
}