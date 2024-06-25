To build from scratch
```shell
./mvnw clean
```

then
```shell
./mvnw -Dmaven.repo.local=target/repo verify
```

(`assembly:single` attached to `package`)

Usage
1. Unzip autesty-${version}-4at.zip
2. cd autesty-${version}
3. mvn with `--offline -Dmaven.repo.local=repo` should work
