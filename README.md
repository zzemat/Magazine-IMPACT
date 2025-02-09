# **Magazine Impact Project**

Bienvenue dans le projet **Magazine Impact**, une plateforme collaborative permettant aux étudiants de partager leurs hobbies, idées et expériences. Ce document décrit le projet, les processus que nous utilisons avec **Jira** et **GitHub**, et les automatisations en place.

---

## **🎯 Objectif du projet**
Créer un site web interactif où les étudiants peuvent :  
- Partager leurs compétences et expériences.  
- Découvrir et échanger avec d'autres étudiants partageant les mêmes intérêts.  
- Contribuer à une communauté dynamique et collaborative.

---

## **🛠️ Processus du projet avec Jira et GitHub**

Nous utilisons un workflow agile basé sur **Jira** et **GitHub** pour gérer efficacement les tâches de développement :

1. **Création des issues dans Jira**  
   - Chaque fonctionnalité, amélioration ou bug est créé sous forme d’issue dans Jira.  
   - Chaque issue contient un numéro unique (exemple : `JIRA-101`, pour notre projet : MI-XXX).

2. **Transition des issues**  
   - Une issue passe par plusieurs statuts dans Jira :  
     - `To Do` : Tâches à faire.  
     - `In Progress` : Tâches en cours.  
     - `Review` : En attente de validation via une Pull Request.  
     - `Done` : Tâche terminée.

---

## **⚙️ Automatisations mises en place**

### **1. Création automatique de branches**
- **Quand ?** Lorsqu’une issue passe au statut `In Progress` dans Jira.  
- **Action :** Une branche GitHub est créée automatiquement avec un nom basé sur l’issue Jira.  
  - **Format de la branche :** `issue_key-summary`  
  - **Exemple :** `MI-101-add-login-page`  
- **Avantage :** Gain de temps et standardisation des noms de branches.  

### **2. Liaison automatique des Pull Requests**
- **Quand ?** Lorsqu'une **Pull Request (PR)** est créée sur GitHub.  
- **Action :**  
  - La PR est automatiquement liée à l’issue Jira correspondante (grâce à l’ID dans le nom de la branche ou du commit).  
  - Un commentaire est ajouté à l’issue Jira avec un lien vers la PR ou branch et l'issue passe à l'état "review" .  
- **Avantage :** Suivi clair des révisions de code et amélioration de la collaboration.

### **3. Fermeture automatique des issues**
- **Quand ?** Lorsqu’une **Pull Request est mergée** sur GitHub.  
- **Action :** L’issue Jira associée est automatiquement déplacée au statut `Done`.  
- **Avantage :** Synchronisation parfaite entre le statut des issues et l'état du code.  

---

## **🚀 Instructions pour les développeurs**

### **1. Commencer une nouvelle tâche**
1. Assurez-vous que l'issue associée dans Jira est bien en statut `In Progress`.  
2. Une branche sera automatiquement créée dans GitHub. Vous pouvez la retrouver dans le repo.

### **2. Travailler sur une branche**
1. Clonez le repo et récupérez la branche correspondante :  

   git fetch
   git checkout issue_key-summary

2. Travaillez sur votre code et faites vos commits en incluant l’issue_key dans le message :

   git commit -m "[MI-101] Implémentation de la fonctionnalité X"

### 3. Créer une Pull Request
Poussez vos modifications sur GitHub :

git push origin issue_key-summary
Ouvrez une Pull Request (PR) via GitHub. Assurez-vous que :
Le titre contient l’issue_key (exemple : MI-101 Add login feature).
La PR est associée à l’issue Jira correspondante.
### 4. Finaliser une tâche
Une fois la PR approuvée et mergée :

L’issue Jira passera automatiquement au statut Done.
La branche sera prête pour suppression.

### 📞 Contact
En cas de question, n'hésitez pas à me contacter directement sur WhatsApp
