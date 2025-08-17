Write-Host "=== Démarrage de Podman machine ==="
podman machine start

Write-Host "=== Lancement de PostgreSQL via podman-compose ==="

# Récupérer le chemin du script
$scriptDir = Split-Path -Parent $MyInvocation.MyCommand.Path

# Construire le chemin absolu vers le fichier podman-compose.yml
$composeFile = Join-Path $scriptDir "podman-compose.yml"

# Lancer podman-compose avec le chemin absolu
podman-compose -f $composeFile up -d
