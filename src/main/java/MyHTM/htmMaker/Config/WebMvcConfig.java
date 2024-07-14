//package MyHTM.htmMaker.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//public class WebMvcConfig {
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/root/*")	//it is not possible to use /* here
//                        .allowedOrigins("http://127.0.0.1:3000")
//                        .allowCredentials(true);
//                //allow all get and post requests to the endpoint /version
//                registry.addMapping("/version")	//it is not possible to use /* here
//                        .allowedOrigins("http://127.0.0.1:3000")
//                        .allowCredentials(true);
//            }
//        };
//    }
//}
