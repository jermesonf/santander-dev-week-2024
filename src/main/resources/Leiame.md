# Resources
## O que foi feito
> - Deletado: templetes, static e application.properties (tudo)
pois não foi configurado nada e também não usaremos desta forma.

> - Criado: documento.yml pois é mais flexivel (application-dev.yml)

### Código de "application-dev.yml"

```

#Configurações Spring
spring:

   #Configurações Banco de dados
   database:
      #Criado o banco h2 com o nome sdw2023
      url: jdbc:h2:mem:sdw2023
      #Usuario: sdw2023
      username: sdw2023
      #Senha: sem senha
      password:
   
   #Configurações JPA
   jpa:
      #Essas configurações deixa as queryes mais verbosa e são mostradas no LOG
      show-sql: true
      open-in-view: false
      #hibernate crie as tabelas do banco no primeiro momento
      hibernate:
         ddl-auto: create # validate / update / create / create - drop
      properties:
         hibernate:
            format_sql: true
            
   #Configurações H2
   h2:
      console:
         enabled: true
         #/h2-console para acessar o banco no navegador
         path: /h2-console
         settings:
            trace: false
            web-allow-others: false
            
```