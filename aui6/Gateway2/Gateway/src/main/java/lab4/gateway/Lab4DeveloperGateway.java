package lab4.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lab4DeveloperGateway {
	public static void main(String[] args) {
		SpringApplication.run(Lab4DeveloperGateway.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder, @Value("${lab4.member.url}") String memberUrl,
			@Value("${lab4.project.url}") String projectUrl, @Value("${lab4.gateway.host}") String host) {
		return builder.routes()
				.route("projects", route -> route.host(host)
						.and()
						.path("/api/projects/{uuid}", "/api/projects")
						.uri(projectUrl))
				.route("members", route -> route.host(host)
						.and()
						.path("/api/members", "/api/members/**", "/api/projects/{uuid}/members",
								"/api/projects/{uuid}/members/**")
						.uri(memberUrl))
				.build();
	}

}
