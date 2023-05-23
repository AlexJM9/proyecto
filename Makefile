build-image:
	@ docker build -f devops/Dockerfile -t grupo6backend:1 .
volume:
	@ docker volume create pg_tendencia_grupseis
deploy:
	@ docker stack deploy --with-registry-auth -c devops/stack.yml gruposeis
rm:
	@ docker stack rm gruposeis