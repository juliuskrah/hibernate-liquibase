# Liquibase Hibernate Demo

This repository contains the code accompanying the tutorial at <>..

## Running the application

To run this demo, run the following command

```bash
> .\mvnw exec:exec
```

## Getting the dependencies

You can run the command below to get the library files for the migration:

```bash
> .\mvnw dependency:copy-dependencies -DoutputDirectory=${project.build.directory}/lib -Dhttps.protocols=TLSv1.2
```

## Generate Changelog

Use the following command to generate a changelog XML file

### From CLI

```bash
> .\mvnw install
> liquibase --logLevel=INFO --defaultsFile=src/main/resources/liquibase.properties generateChangeLog
```

### From Maven

```bash
> .\mvnw liquibase:generateChangeLog
```
