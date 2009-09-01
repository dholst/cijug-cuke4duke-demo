package net.cijug.demo.soccer.cukes;

import com.sun.jersey.spi.spring.container.servlet.SpringServlet;
import org.springframework.mock.web.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.Filter;
import java.util.List;
import java.util.Map;

public class World {
    private static KillStupidJavaUtilLogging killIt = new KillStupidJavaUtilLogging();
    private static Filter filter;
    private JdbcUtil jdbc = new JdbcUtil();
    private MockServletContext servletContext = new MockServletContext();
    private MockHttpServletRequest request = new MockHttpServletRequest();
    private MockHttpServletResponse response = new MockHttpServletResponse();

    public void destroy() {
        jdbc.destroy();
    }

    public void clearTable(String table) {
        jdbc.clear(table);
    }

    public void populateTable(String table, List<Map<String, String>> rows) {
        jdbc.addRows(table, rows);
    }

    public void get(String resource, String format) throws Exception {
        String uri = "/context/" + resource;
        request.addHeader("Accept", format);
        request.setMethod("GET");
        request.setScheme("http");
        request.setServerName("localhost");
        request.setContextPath("/context");
        request.setRequestURI(uri);
        getFilter().doFilter(request, response, new MockFilterChain());
    }

    private Filter getFilter() throws Exception {
        if (filter == null) {
            filter = new SpringServlet();
            servletContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, ApplicationContextFactory.getApplicationContext());
            MockFilterConfig filterConfig = new MockFilterConfig(servletContext);
            filterConfig.addInitParameter("com.sun.jersey.config.property.packages", "net.cijug");
            filter.init(filterConfig);
        }

        return filter;
    }

    public String getResponseStatus() {
        return String.valueOf(response.getStatus());
    }

    public String getResponseContent() throws Exception {
        return response.getContentAsString();
    }
}
