# jhipster2

This application was generated using JHipster 7.9.3, you can find documentation and help at [https://www.jhipster.tech/documentation-archive/v7.9.3](https://www.jhipster.tech/documentation-archive/v7.9.3).


## Building for production

### Packaging as jar

To build the final jar and optimize the jhipster2 application for production, run:

```
./mvnw -Pprod clean verify
```

This will concatenate and minify the client CSS and JavaScript files. It will also modify `index.html` so it references these new files.
To ensure everything worked, run:

```
java -jar target/*.jar
```

Then navigate to [http://localhost:8080](http://localhost:8080) in your browser.

## Continuous Integration (optional)

To configure CI for your project, run the ci-cd sub-generator (`jhipster ci-cd`), this will let you generate configuration files for a number of Continuous Integration systems. Consult the [Setting up Continuous Integration][] page for more information.

[jhipster homepage and latest documentation]: https://www.jhipster.tech
[jhipster 7.9.3 archive]: https://www.jhipster.tech/documentation-archive/v7.9.3
[using jhipster in development]: https://www.jhipster.tech/documentation-archive/v7.9.3/development/
[using docker and docker-compose]: https://www.jhipster.tech/documentation-archive/v7.9.3/docker-compose
[using jhipster in production]: https://www.jhipster.tech/documentation-archive/v7.9.3/production/
[running tests page]: https://www.jhipster.tech/documentation-archive/v7.9.3/running-tests/
[code quality page]: https://www.jhipster.tech/documentation-archive/v7.9.3/code-quality/
[setting up continuous integration]: https://www.jhipster.tech/documentation-archive/v7.9.3/setting-up-ci/
[node.js]: https://nodejs.org/
[npm]: https://www.npmjs.com/
[webpack]: https://webpack.github.io/
[browsersync]: https://www.browsersync.io/
[jest]: https://facebook.github.io/jest/
[leaflet]: https://leafletjs.com/
[definitelytyped]: https://definitelytyped.org/
