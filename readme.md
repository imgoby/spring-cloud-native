sdk use java 24.2.r24-nik

mvn clean package native:compile


curl localhost:8080/fst
curl http://localhost:8080/api/search


参考：
https://github.com/elastic/elasticsearch-java

按官方说明：应该最大支持：elasticsearch 8.13.4,但目前直接安装elasticsearch 9是否带来风险。