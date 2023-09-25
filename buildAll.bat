call cd apigateway
call ../apigateway/build.bat
call cd ..
call cd api2
call ../api2/build.bat
call cd ..
call cd api1
call ../api1/build.bat
call cd ..
::call docker-compose build --no-cache --progress=plain
call docker-compose up --build --force-recreate