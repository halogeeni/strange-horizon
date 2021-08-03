# strange-horizon-api
[![GitHub](https://img.shields.io/github/license/halogeeni/strange-horizon-api)](https://github.com/halogeeni/strange-horizon-api/blob/master/LICENSE.md)

API for Strange Horizon record label. Work in progress.

This is also an experiment to work with new Java goodies:
* Java 12
* Spring Boot 2.5
* JUnit 5

## Tests
Run unit & integration tests via Maven with `mvn clean test`

This project uses [MariaDB4j](https://github.com/vorburger/MariaDB4j) as DB for integration tests.
MariaDB4j has a known `libssl` [version conflict issue on MacOS](https://github.com/vorburger/MariaDB4j/issues/411).

This can be worked around by creating following symlinks:
```
ln -s /usr/lib/libcrypto.dylib /usr/local/opt/openssl/lib/libcrypto.1.0.0.dylib
ln -s /usr/lib/libssl.dylib /usr/local/opt/openssl/lib/libssl.1.0.0.dylib 
```
