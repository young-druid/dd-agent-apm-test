I created a sample project to test dd-trace-java [issue 2117](https://github.com/DataDog/dd-trace-java/issues/2117).

Please, do the following steps:

- `./gradlew clean bootRun`. Wait until application is strated.
- execute `curl -X GET http://localhost:8080/test `
- stop spring application with Ctrl+C
- check this `build/dd-agent/log.txt` file. You won't find that any traces for `netty.request`.

After that, downgrade `id 'org.springframework.boot' version '2.4.3'` to `id 'org.springframework.boot' version '2.3.9.RELEASE'` in `build.gradle`. 
Repeat the steps above. If you check log.txt you can find that traces for `netty.request` are being sent.

It looks like versions of spring-web-flux, netty and projectreactor which can be found in the latest 
spring-boot 2.4.3 should be supported by dd-java-agent. But for some reason in the latest spring-boot 
you cannot get `netty.request` traces in datadog apm because of this bug 
(if it is a bug and not some configuration issue).