package com.project.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInit extends AbstractSecurityWebApplicationInitializer {
//    Класс SecurityWebApplicationInitializer для наследования AbstractSecurityWebApplicationInitializer
//    Нет необходимости переписывать какой-либо метод, что эквивалентно настройке следующих параметров в web.xml
//            <filter>
//        <filter-name>springSecurityFilterChain</filter-name>
//        <filter-class>org.springframework.web.filter.DelegatingFilterProxy</filter-class>
//        </filter>
//        <filter-mapping>
//        <filter-name>springSecurityFilterChain</filter-name>
//        <url-pattern>/*</url-pattern>
//        </filter-mapping>
}
