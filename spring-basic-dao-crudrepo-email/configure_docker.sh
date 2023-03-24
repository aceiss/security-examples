#!/bin/bash

# Prompt for required variables
read -p "Enter ACEISS_API_KEY: " ACEISS_API_KEY
read -p "Enter ACEISS_AGENT_PATH (default ./agent/): " ACEISS_AGENT_PATH
ACEISS_AGENT_PATH=${ACEISS_AGENT_PATH:-"./agent/"}
read -p "Enter ACEISS_USER_LIST_REFRESH_DELAY (default 86400 ): " ACEISS_USER_LIST_REFRESH_DELAY
ACEISS_USER_LIST_REFRESH_DELAY=${ACEISS_USER_LIST_REFRESH_DELAY:-"86400"}
read -p "Enter Host Port (default 8080): " HOST_PORT
HOST_PORT=${HOST_PORT:-8080}
# Generate start_docker.sh script
echo "#!/bin/bash" > start_docker.sh
echo "" >> start_docker.sh
echo "export ACEISS_API_KEY=$ACEISS_API_KEY" >> start_docker.sh
echo "export ACEISS_AGENT_PATH=$ACEISS_AGENT_PATH" >> start_docker.sh
echo "export HOST_PORT=$HOST_PORT" >> start_docker.sh
echo "export ACEISS_USER_LIST_REFRESH_DELAY=$ACEISS_USER_LIST_REFRESH_DELAY" >> start_docker.sh 
echo "docker-compose up" >> start_docker.sh
chmod +x start_docker.sh

echo "Docker environment configured. To start the containers, run './start_docker.sh'"

