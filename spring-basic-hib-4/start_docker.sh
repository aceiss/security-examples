#!/bin/bash

export ACEISS_API_KEY=GcLsfiV1MxH9DEDOycij3Vb6sjoxT5mLF0Ew8hRZdk7piEPIEWXL71SwVQY_G4.HjBtj6jEOJBJwBeXF1pMMQhKGAVmX80_O2vbkkDTR5TX7iMA00SspN80NnKXjqKPZaCd7vRBy7klhhZjZR4P_KCvMGlOeT21jG0Lxlm81dRzuXGjAU1nyNWdY1a9fAT_UXa4W1MRWM6dKhJBDwRYNcy6MrmCLVYuRf9sE2im1ROrdlCchomp1RGuFVywIssjaqE2ERMWkSxGfOfvsSN21SSD39g27f3VSidPsIN-9yOYMrx
export ACEISS_AGENT_PATH=/Users/EricB/aceiss/mac/javaagent/agent/build/libs
export HOST_PORT=8080
#4 hrs
export ACEISS_USER_LIST_REFRESH_DELAY=360
export ACEISS_USER_LIST_REFRESH_DELAY=13:10:11
export ACEISS_API_ENDPOINT=http://localhost:4318/
docker-compose up


     -> enduser.scope: Str(ROLE_ADMIN,ROLE_CATALOG_MGR)
     -> enduser.id: Str(Allan.Burton)
     -> enduser.details: Str({"address":"1244 Golf St.","email":"Allen.Burton@sailpointdemo.com","firstName":"Allan","lastName":"Burton","name":"Allan Burton","userRoles":[{"id":12,"role":"ADMIN","username":"Allan.Burton"},{"id":13,"role":"CATALOG_MGR","username":"Allan.Burton"}],"username":"Allan.Burton"})
     -> thread.id: Int(62)
     -> thread.name: Str(pool-4-thread-1)
     -> enduser.principal: Str({"accountNonExpired":true,"accountNonLocked":true,"address":"1244 Golf St.","authorities":[{"authority":"ROLE_ADMIN"},{"authority":"ROLE_CATALOG_MGR"}],"credentialsNonExpired":true,"email":"Allen.Burton@sailpointdemo.com","enabled":true,"firstName":"Allan","lastName":"Burton","username":"Allan.Burton"})

Span #5
    Trace ID       : 0e2ef1d5241c61496da6ce085af80820
    Parent ID      :
    ID             : 6e463f3cdad66908
    Name           : UserList
    Kind           : Server
    Start time     : 2024-02-07 02:14:16.907455 +0000 UTC
    End time       : 2024-02-07 02:14:16.907515833 +0000 UTC
    Status code    : Unset
    Status message :
Attributes:
     -> enduser.details: Str("{\"ADDRESS\":\"1244 Golf St.\",\"USERNAME\":\"Allan.Burton\",\"ENABLED\":\"1\",\"EMAIL\":\"Allen.Burton@sailpointdemo.com\",\"LAST_NAME\":\"Burton\",\"FIRST_NAME\":\"Allan\",\"NAME\":\"Allan Burton\"}")
     -> enduser.id: Str(Allan.Burton)
     -> thread.id: Int(61)
     -> thread.name: Str(pool-3-thread-1)

ETB {"ADDRESS":"1244 Golf St.","USERNAME":"Allan.Burton","ENABLED":"1","EMAIL":"Allen.Burton@sailpointdemo.com","LAST_NAME":"Burton","FIRST_NAME":"Allan","NAME":"Allan Burton"} Class class java.lang.String



ScopeSpans #1
ScopeSpans SchemaURL:
InstrumentationScope io.opentelemetry.tomcat-7.0 1.32.0-alpha
Span #0
    Trace ID       : 82c3b1307194e1f0689b911d659b4f51
    Parent ID      :
    ID             : a9dd9cbd23db9289
    Name           : GET /servlet-io-no-spring-security/u_login
    Kind           : Server
    Start time     : 2024-02-07 16:19:47.481952 +0000 UTC
    End time       : 2024-02-07 16:19:47.498174583 +0000 UTC
    Status code    : Unset
    Status message :
Attributes:
     -> net.host.name: Str(localhost)
     -> user_agent.original: Str(Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.2.1 Safari/605.1.15)
     -> http.target: Str(/servlet-io-no-spring-security/u_login?userId=BakerE&password=password)
     -> net.sock.peer.addr: Str(0:0:0:0:0:0:0:1)
     -> thread.name: Str(http-nio-8080-exec-9)
     -> net.host.port: Int(8080)
     -> enduser.id: Str(BakerE)
     -> http.response_content_length: Int(451)
     -> net.sock.host.addr: Str(0:0:0:0:0:0:0:1)
     -> http.status_code: Int(200)
     -> http.route: Str(/servlet-io-no-spring-security/u_login)
     -> net.sock.host.port: Int(8080)
     -> thread.id: Int(57)
     -> enduser.session: Int(2845537)
     -> net.protocol.name: Str(http)
     -> net.sock.peer.port: Int(59556)
     -> http.method: Str(GET)
     -> net.protocol.version: Str(1.1)
     -> http.scheme: Str(http)


ScopeSpans #1
ScopeSpans SchemaURL:
InstrumentationScope io.opentelemetry.tomcat-7.0 1.32.0-alpha
Span #0
    Trace ID       : bd47046beebe2e4a175a18ceb68f5759
    Parent ID      :
    ID             : 0bba3fdb7d5c95bd
    Name           : GET /servlet-io-no-spring-security/u_login
    Kind           : Server
    Start time     : 2024-02-07 16:26:41.57461 +0000 UTC
    End time       : 2024-02-07 16:26:41.801357875 +0000 UTC
    Status code    : Unset
    Status message :
Attributes:
     -> net.host.name: Str(localhost)
     -> user_agent.original: Str(Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/17.2.1 Safari/605.1.15)
     -> http.target: Str(/servlet-io-no-spring-security/u_login?userId=Jill.User&password=password)
     -> net.sock.peer.addr: Str(0:0:0:0:0:0:0:1)
     -> thread.name: Str(http-nio-8080-exec-2)
     -> net.host.port: Int(8080)
     -> http.response_content_length: Int(454)
     -> net.sock.host.addr: Str(0:0:0:0:0:0:0:1)
     -> http.status_code: Int(200)
     -> http.route: Str(/servlet-io-no-spring-security/u_login)
     -> net.sock.host.port: Int(8080)
     -> thread.id: Int(50)
     -> net.protocol.name: Str(http)
     -> net.sock.peer.port: Int(59585)
     -> http.method: Str(GET)
     -> net.protocol.version: Str(1.1)
     -> http.scheme: Str(http)


select adminuseri0_.ADMIN_USER_ID as admin_us1_11_, adminuseri0_.ACTIVE_STATUS_FLAG as active_s2_11_, adminuseri0_.ARCHIVED as archived3_11_, adminuseri0_.CREATED_BY as created_4_11_, adminuseri0_.DATE_CREATED as date_cre5_11_, adminuseri0_.DATE_UPDATED as date_upd6_11_, adminuseri0_.UPDATED_BY as updated_7_11_, adminuseri0_.EMAIL as email8_11_, adminuseri0_.LOGIN as login9_11_, adminuseri0_.NAME as name10_11_, adminuseri0_.PASSWORD as passwor11_11_, adminuseri0_.PHONE_NUMBER as phone_n12_11_, adminuseri0_1_.SANDBOX_ID as sandbox_1_15_ from BLC_ADMIN_USER adminuseri0_ left outer join BLC_ADMIN_USER_SANDBOX adminuseri0_1_ on adminuseri0_.ADMIN_USER_ID=adminuseri0_1_.ADMIN_USER_ID where adminuseri0_.LOGIN=?

select allroles0_.ADMIN_USER_ID as admin_us1_14_1_, allroles0_.ADMIN_ROLE_ID as admin_ro2_14_1_, adminrolei1_.ADMIN_ROLE_ID as admin_ro1_7_0_, adminrolei1_.CREATED_BY as created_2_7_0_, adminrolei1_.DATE_CREATED as date_cre3_7_0_, adminrolei1_.DATE_UPDATED as date_upd4_7_0_, adminrolei1_.UPDATED_BY as updated_5_7_0_, adminrolei1_.DESCRIPTION as descript6_7_0_, adminrolei1_.NAME as name7_7_0_
from BLC_ADMIN_USER_ROLE_XREF allroles0_
inner join BLC_ADMIN_ROLE adminrolei1_ on allroles0_.ADMIN_ROLE_ID=adminrolei1_.ADMIN_ROLE_ID where allroles0_.ADMIN_USER_ID=?

jmx.app.name=admin
http.server.port=8081
server.port=8444
server.ssl.key-store = classpath:blc-example.keystore
server.ssl.key-store-password = broadleaf
server.ssl.key-password = broadleaf


export ACEISS_USER_LIST_QUERY="SELECT emp.*, roles.NAME as ROLE FROM BLC_ADMIN_USER emp JOIN BLC_ADMIN_USER_ROLE_XREF rxref on emp.admin_user_id = rxref.admin_user_id JOIN BLC_ADMIN_ROLE roles on rxref.admin_role_id = roles.admin_role_id"
