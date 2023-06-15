build-image:
	@ docker build -f devops/Dockerfile -t pedidosbackend:1 .
volume:
	@ docker volume create pg_tendencia_data
deploy:
	@ docker stack deploy --with-registry-auth -c devops/stack.yml pedidos
rm:
	@ docker stack rm pedidos
	