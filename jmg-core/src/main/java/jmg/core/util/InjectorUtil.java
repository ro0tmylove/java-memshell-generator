package jmg.core.util;


import jmg.core.config.Constants;
import jmg.core.template.*;

import java.util.HashMap;
import java.util.Map;

public class InjectorUtil {

    private static final Map<String, String> INJECTOR_CLASSNAME_MAP = new HashMap();
    private static final Map<String, Map<String, String>> classMap = new HashMap();


    public InjectorUtil() {
    }

    public static String getInjectorName(String serverType, String shellType) {
        Map<String, String> injectorMap = (Map) classMap.get(serverType);
        return injectorMap == null ? "" : injectorMap.getOrDefault(shellType, "");
    }

    public static String getInjectorClassName(String injectorName) throws Exception {
        if (INJECTOR_CLASSNAME_MAP.get(injectorName) == null) {
            throw new Exception("Invalid injector type '" + injectorName + "'");
        } else {
            return INJECTOR_CLASSNAME_MAP.getOrDefault(injectorName, "");
        }
    }

    static {


        INJECTOR_CLASSNAME_MAP.put("GlassfishListenerInjector", GlassFishListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("GlassfishFilterInjector", GlassFishFilterInjectorTpl.class.getName());
        Map<String, String> glassfishMap = new HashMap();
        glassfishMap.put(Constants.SHELL_LISTENER, "GlassfishListenerInjector");
        glassfishMap.put(Constants.SHELL_FILTER, "GlassfishFilterInjector");
        classMap.put(Constants.SERVER_GLASSFISH, glassfishMap);

        INJECTOR_CLASSNAME_MAP.put("JettyListenerInjector", JettyListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("JettyFilterInjector", JettyFilterInjectorTpl.class.getName());
        Map<String, String> jettyMap = new HashMap();
        jettyMap.put(Constants.SHELL_LISTENER, "JettyListenerInjector");
        jettyMap.put(Constants.SHELL_FILTER, "JettyFilterInjector");
        classMap.put(Constants.SERVER_JETTY, jettyMap);


        INJECTOR_CLASSNAME_MAP.put("ResinListenerInjector", ResinListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("ResinFilterInjector", ResinFilterInjectorTpl.class.getName());
        Map<String, String> resinMap = new HashMap();
        resinMap.put(Constants.SHELL_LISTENER, "ResinListenerInjector");
        resinMap.put(Constants.SHELL_FILTER, "ResinFilterInjector");
        classMap.put(Constants.SERVER_RESIN, resinMap);

        INJECTOR_CLASSNAME_MAP.put("TomcatListenerInjector", TomcatListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("TomcatFilterInjector", TomcatFilterInjectorTpl.class.getName());
        Map<String, String> tomcatMap = new HashMap();
        tomcatMap.put(Constants.SHELL_LISTENER, "TomcatListenerInjector");
        tomcatMap.put(Constants.SHELL_FILTER, "TomcatFilterInjector");
        classMap.put(Constants.SERVER_TOMCAT, tomcatMap);


        INJECTOR_CLASSNAME_MAP.put("UndertowListenerInjector", UndertowListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("UndertowFilterInjector", UndertowFilterInjectorTpl.class.getName());
        Map<String, String> undertowMap = new HashMap();
        undertowMap.put(Constants.SHELL_LISTENER, "UndertowListenerInjector");
        undertowMap.put(Constants.SHELL_FILTER, "UndertowFilterInjector");
        classMap.put(Constants.SERVER_UNDERTOW, undertowMap);

        INJECTOR_CLASSNAME_MAP.put("WebLogicListenerInjector", WebLogicListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("WebLogicFilterInjector", WebLogicFilterInjectorTpl.class.getName());
        Map<String, String> weblogicMap = new HashMap();
        weblogicMap.put(Constants.SHELL_LISTENER, "WebLogicListenerInjector");
        weblogicMap.put(Constants.SHELL_FILTER, "WebLogicFilterInjector");
        classMap.put(Constants.SERVER_WEBLOGIC, weblogicMap);

        INJECTOR_CLASSNAME_MAP.put("WebSphereListenerInjector", WebSphereListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("WebSphereFilterInjector", WebSphereFilterInjectorTpl.class.getName());
        Map<String, String> websphereMap = new HashMap();
        websphereMap.put(Constants.SHELL_LISTENER, "WebSphereListenerInjector");
        websphereMap.put(Constants.SHELL_FILTER, "WebSphereFilterInjector");
        classMap.put(Constants.SERVER_WEBSPHERE, websphereMap);

        INJECTOR_CLASSNAME_MAP.put("JBossListenerInjector", TomcatListenerInjectorTpl.class.getName());
        INJECTOR_CLASSNAME_MAP.put("JBossFilterInjector", TomcatFilterInjectorTpl.class.getName());
        Map<String, String> jbossMap = new HashMap();
        jbossMap.put(Constants.SHELL_LISTENER, "JBossListenerInjector");
        jbossMap.put(Constants.SHELL_FILTER, "JBossFilterInjector");
        classMap.put(Constants.SERVER_JBOSS, jbossMap);


        INJECTOR_CLASSNAME_MAP.put("SpringMVCInterceptorInjector", SpringMVCInterceptorInjectorTpl.class.getName());
        Map<String, String> springMVCMap = new HashMap();
        springMVCMap.put(Constants.SHELL_INTERCEPTOR, "SpringMVCInterceptorInjector");
        classMap.put(Constants.SERVER_SPRING_MVC, springMVCMap);


        INJECTOR_CLASSNAME_MAP.put("SpringWebFluxHandlerMethodInjector", SpringWebFluxHandlerMethodInjectorTpl.class.getName());
        Map<String, String> springWebFluxMap = new HashMap();
        springWebFluxMap.put(Constants.SHELL_WF_HANDLERMETHOD, "SpringWebFluxHandlerMethodInjector");
        classMap.put(Constants.SERVER_SPRING_WEBFLUX, springWebFluxMap);
    }
}
