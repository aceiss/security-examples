package com.baeldung.oauth2.resource.server;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/api")
@DeclareRoles({"resource.read", "resource.write", "resource.catmgr"})
@LoginConfig(authMethod = "MP-JWT")
public class OAuth2ResourceServerApplication extends Application {
}
