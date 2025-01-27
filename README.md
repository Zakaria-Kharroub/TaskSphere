# TaskSphere

## Contexte du Projet

TaskSphere a été conçu pour combler les lacunes des outils traditionnels de gestion des tâches, en offrant une plateforme performante et centrée sur l'utilisateur. En utilisant **JAKARTA EE** comme base, TaskSphere intègre des fonctionnalités avancées telles que la recherche par tags, les contraintes de planification, et des mises à jour automatisées pour simplifier et enrichir la gestion des tâches dans des environnements de travail dynamiques.

TaskSphere s'adresse aux individus, chefs d'équipe et managers, leur offrant des outils robustes pour la collaboration et le suivi des projets.

---

![Thumbnail 1](https://github.com/Zakaria-Kharroub/TaskSphere/blob/bf7b133dfb5a9849b58b8303a59c6186e5f956fe/tasksphere.png)

---

## Versions et Fonctionnalités

### Version 1.0.0

1. **Configuration de l’Environnement** :
   - Configuration de l’IDE, du serveur d’application, de la base de données, et des outils nécessaires.
   - Mise en place d’une structure de projet JAKARTA EE bien organisée.
   - Adoption des bonnes pratiques de développement.

2. **Gestion des Utilisateurs (CRUD)** :
   - **Attributs** : 
     - ID
     - Nom d'utilisateur
     - Mot de passe
     - Nom
     - Prénom
     - Adresse e-mail
     - Manager

3. **Technologies Utilisées** :
   - Maven
   - JAKARTA EE
   - Hibernate
   - Tomcat/JBoss/GlassFish (au choix)
   - JPA
   - Servlets
   - JSP

---

### Version 1.1.0

1. **Contraintes de Planification** :
   - Une tâche ne peut pas être créée dans le passé.
   - Les utilisateurs doivent obligatoirement ajouter plusieurs tags à chaque tâche.
   - La planification est limitée à un délai maximum de 3 jours à l’avance.

2. **Gestion des Jetons** :
   - Les utilisateurs disposent de :
     - **2 jetons par jour** pour remplacer une tâche attribuée par leur manager.
     - **1 jeton par mois** pour supprimer une tâche.
   - Supprimer une tâche créée par l’utilisateur n’affecte pas le solde des jetons.

3. **Règles de Gestion des Tâches** :
   - Les utilisateurs peuvent uniquement s’attribuer des tâches.
   - Marquer une tâche comme terminée doit obligatoirement se faire avant la date limite.

4. **Déploiement** :
   - Après l'implémentation des fonctionnalités ci-dessus, l’application doit être déployée sur un repository local.

---

### Version 1.2.0

1. **Gestion Avancée des Remplacements** :
   - Les managers peuvent remplacer une tâche par une autre, mais doivent obligatoirement l'assigner à un autre utilisateur.
   - Ces tâches ne peuvent plus être modifiées ou supprimées par un jeton.

2. **Améliorations Automatiques** :
   - Si un manager ne répond pas à une demande de remplacement de tâche dans un délai de 12 heures, l'utilisateur concerné reçoit un double solde de jetons de modification le lendemain.
   - Les tâches dépassant leur date limite sont automatiquement marquées comme non effectuées toutes les 24 heures.

3. **Tableau de Bord pour Managers** :
   - Vue d'ensemble des tâches assignées à leurs employés.
   - Statistiques :
     - Pourcentage d’achèvement par tags (semaine, mois, année).
     - Nombre de jetons utilisés.

4. **Déploiement** :
   - Une fois les nouvelles fonctionnalités développées, l’application doit être mise à jour dans le repository local.
  
---

Avec **TaskSphere**, simplifiez la gestion de vos tâches et améliorez la collaboration au sein de votre équipe !
