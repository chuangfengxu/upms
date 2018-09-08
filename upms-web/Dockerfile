FROM java:8-jre

LABEL maintainer="xuchuangfeng@yy.com"

WORKDIR /usr/sellercube/upms-web/

ADD upms-web-1.0.0.jar .

CMD ["-Xmx200m", "upms-web-1.0.0.jar"]

ENTRYPOINT ["java", "-jar"]

EXPOSE 8888