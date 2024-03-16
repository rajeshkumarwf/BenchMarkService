API

**localhost:8081/esg/benchmark/upload/<entityName>**
send pdf in body
This will upload the PDF to azure storge and then call engine to generate 
benchmark.
Retrieve benchmark data by entityName from cosmosdb and return as response 

**localhost:8081/esg/benchmark/upload/<entityName>/<esgType>/<esgIndicator>**
This will upload the PDF to azure storge and then call engine to generate 
benchmark.
Retrieve benchmark data by entityName,esgType & esgIndicator from cosmosdb and return as response 
send pdf in body

**localhost:8081/esg/benchmark/keepalive**
healthcheck of application

localhost:8081/esg/benchmark/upload/v1/<entityName>
api to upload pdf and then call engine async

**localhost:8081/esg/benchmark/fetch/v1/<entityName**>
fetch data by entityName
