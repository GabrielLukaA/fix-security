//package br.org.sesisenai.ava.security.filter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//@Component
//@AllArgsConstructor
//public class FilterAuthentication extends OncePerRequestFilter {
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//        if (!publicRoute(request)){
//         return;
//        }
//
//    }
//
//    private boolean publicRoute(HttpServletRequest request) {
//        System.out.println(request.toString());
//        return request.getRequestURI().equals("/api/usuarios") && request.getMethod().equals("POST");
//    }
//}
