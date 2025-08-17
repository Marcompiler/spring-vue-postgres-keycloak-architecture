#!/bin/bash

echo "=== Démarrage de Podman machine ==="
podman machine start

echo "=== Lancement de PostgreSQL via podman-compose ==="

# Récupérer le chemin du script (même si lancé ailleurs)
script_dir="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

# Construire le chemin absolu vers le fichier podman-compose.yml
compose_file="$script_dir/podman-compose.yml"

# Lancer podman-compose avec le chemin absolu
podman-compose -f "$compose_file" up -d
