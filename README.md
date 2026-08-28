# Spring API


## Usage

```bash
# create .env file from example (don't forget to fill out actual values).
$ cp ./env.example ./.env

# create build, which also downloads dependencies.
$ gradle build

# start application (migrations will be applied by Flyway automatically).
$ gradle bootRun
```

## TODO

- [ ] Database pool size (Hikari min / max size).