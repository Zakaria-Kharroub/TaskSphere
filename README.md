<p align="center">
    <h1 align="center">TASKSPHERE</h1>
<p align="center">
	<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat&logo=openjdk&logoColor=white" alt="java">
</p>

<br>

#####  Table of Contents

- [ Overview](#-overview)
- [ Features](#-features)
- [ Repository Structure](#-repository-structure)
- [ Modules](#-modules)
- [ Getting Started](#-getting-started)
    - [ Prerequisites](#-prerequisites)
    - [ Installation](#-installation)
    - [ Usage](#-usage)
    - [ Tests](#-tests)
- [ Project Roadmap](#-project-roadmap)
- [ Contributing](#-contributing)
- [ License](#-license)
- [ Acknowledgments](#-acknowledgments)

---

##  Features

<code>❯ REPLACE-ME</code>

---

##  Repository Structure

```sh
└── TaskSphere/
    ├── conf
    │   ├── Catalina
    │   ├── catalina.policy
    │   ├── catalina.properties
    │   ├── context.xml
    │   ├── jaspic-providers.xml
    │   ├── jaspic-providers.xsd
    │   ├── logging.properties
    │   ├── server.xml
    │   ├── tomcat-users.xml
    │   ├── tomcat-users.xsd
    │   └── web.xml
    ├── logs
    │   ├── catalina.2024-10-18.log
    │   ├── host-manager.2024-10-18.log
    │   ├── localhost.2024-10-18.log
    │   ├── localhost_access_log.2024-10-18.txt
    │   └── manager.2024-10-18.log
    ├── out
    │   └── artifacts
    ├── pom.xml
    ├── src
    │   ├── main
    │   └── test
    └── web
        └── WEB-INF
```

---

##  Modules

<details closed><summary>src.main.java.org.example</summary>

| File | Summary |
| --- | --- |
| [Main.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/Main.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.domaine</summary>

| File | Summary |
| --- | --- |
| [TaskStatus.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/TaskStatus.java) | <code>❯ REPLACE-ME</code> |
| [RequestStatus.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/RequestStatus.java) | <code>❯ REPLACE-ME</code> |
| [User.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/User.java) | <code>❯ REPLACE-ME</code> |
| [Request.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/Request.java) | <code>❯ REPLACE-ME</code> |
| [Tag.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/Tag.java) | <code>❯ REPLACE-ME</code> |
| [Task.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/Task.java) | <code>❯ REPLACE-ME</code> |
| [Role.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/domaine/Role.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.scheduler</summary>

| File | Summary |
| --- | --- |
| [RequestScheduler.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/scheduler/RequestScheduler.java) | <code>❯ REPLACE-ME</code> |
| [TaskScheduler.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/scheduler/TaskScheduler.java) | <code>❯ REPLACE-ME</code> |
| [TokenScheduler.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/scheduler/TokenScheduler.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.errors</summary>

| File | Summary |
| --- | --- |
| [EmailExistException.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/errors/EmailExistException.java) | <code>❯ REPLACE-ME</code> |
| [UserIsEmptyException.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/errors/UserIsEmptyException.java) | <code>❯ REPLACE-ME</code> |
| [EmailFormatInvalid.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/errors/EmailFormatInvalid.java) | <code>❯ REPLACE-ME</code> |
| [UserIsNullException.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/errors/UserIsNullException.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.controller</summary>

| File | Summary |
| --- | --- |
| [StatistiqueServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/StatistiqueServlet.java) | <code>❯ REPLACE-ME</code> |
| [UserServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/UserServlet.java) | <code>❯ REPLACE-ME</code> |
| [TaskServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/TaskServlet.java) | <code>❯ REPLACE-ME</code> |
| [RequestServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/RequestServlet.java) | <code>❯ REPLACE-ME</code> |
| [AuthServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/AuthServlet.java) | <code>❯ REPLACE-ME</code> |
| [LogoutServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/LogoutServlet.java) | <code>❯ REPLACE-ME</code> |
| [TagsServlet.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/controller/TagsServlet.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.repository</summary>

| File | Summary |
| --- | --- |
| [TagRepository.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/repository/TagRepository.java) | <code>❯ REPLACE-ME</code> |
| [TaskRepository.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/repository/TaskRepository.java) | <code>❯ REPLACE-ME</code> |
| [RequestRepository.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/repository/RequestRepository.java) | <code>❯ REPLACE-ME</code> |
| [UserRepository.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/repository/UserRepository.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.java.org.example.service</summary>

| File | Summary |
| --- | --- |
| [RequestService.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/service/RequestService.java) | <code>❯ REPLACE-ME</code> |
| [TaskService.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/service/TaskService.java) | <code>❯ REPLACE-ME</code> |
| [TagService.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/service/TagService.java) | <code>❯ REPLACE-ME</code> |
| [UserService.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/java/org/example/service/UserService.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.webapp</summary>

| File | Summary |
| --- | --- |
| [index.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/index.jsp) | <code>❯ REPLACE-ME</code> |
| [statistiques.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/statistiques.jsp) | <code>❯ REPLACE-ME</code> |
| [tags.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/tags.jsp) | <code>❯ REPLACE-ME</code> |
| [login.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/login.jsp) | <code>❯ REPLACE-ME</code> |
| [test.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/test.jsp) | <code>❯ REPLACE-ME</code> |
| [request.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/request.jsp) | <code>❯ REPLACE-ME</code> |
| [tasks.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/tasks.jsp) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.webapp.css</summary>

| File | Summary |
| --- | --- |
| [bootstrap.min.css](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/css/bootstrap.min.css) | <code>❯ REPLACE-ME</code> |
| [style.css](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/css/style.css) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.main.webapp.layouts</summary>

| File | Summary |
| --- | --- |
| [navbar.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/layouts/navbar.jsp) | <code>❯ REPLACE-ME</code> |
| [sidebar.jsp](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/main/webapp/layouts/sidebar.jsp) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>src.test.java.service</summary>

| File | Summary |
| --- | --- |
| [UserTest.java](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/src/test/java/service/UserTest.java) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>conf</summary>

| File | Summary |
| --- | --- |
| [catalina.policy](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/conf/catalina.policy) | <code>❯ REPLACE-ME</code> |
| [tomcat-users.xsd](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/conf/tomcat-users.xsd) | <code>❯ REPLACE-ME</code> |
| [jaspic-providers.xsd](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/conf/jaspic-providers.xsd) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>logs</summary>

| File | Summary |
| --- | --- |
| [localhost_access_log.2024-10-18.txt](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/logs/localhost_access_log.2024-10-18.txt) | <code>❯ REPLACE-ME</code> |

</details>

<details closed><summary>out.artifacts.testmaven02_Web_exploded.META-INF</summary>

| File | Summary |
| --- | --- |
| [MANIFEST.MF](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/out/artifacts/testmaven02_Web_exploded/META-INF/MANIFEST.MF) | <code>❯ REPLACE-ME</code> |

</details>

---

##  Getting Started

###  Prerequisites

**Java**: `version x.y.z`

###  Installation

Build the project from source:

1. Clone the TaskSphere repository:
```sh
❯ git clone https://github.com/Zakaria-Kharroub/TaskSphere
```

2. Navigate to the project directory:
```sh
❯ cd TaskSphere
```

3. Install the required dependencies:
```sh
❯ mvn clean install
```

###  Usage

To run the project, execute the following command:

```sh
❯ java -jar target/myapp.jar
```

###  Tests

Execute the test suite using the following command:

```sh
❯ mvn test
```

---

##  Project Roadmap

- [X] **`Task 1`**: <strike>Implement feature one.</strike>
- [ ] **`Task 2`**: Implement feature two.
- [ ] **`Task 3`**: Implement feature three.

---

##  Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Report Issues](https://github.com/Zakaria-Kharroub/TaskSphere/issues)**: Submit bugs found or log feature requests for the `TaskSphere` project.
- **[Submit Pull Requests](https://github.com/Zakaria-Kharroub/TaskSphere/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/Zakaria-Kharroub/TaskSphere/discussions)**: Share your insights, provide feedback, or ask questions.

<details closed>
<summary>Contributing Guidelines</summary>

1. **Fork the Repository**: Start by forking the project repository to your github account.
2. **Clone Locally**: Clone the forked repository to your local machine using a git client.
   ```sh
   git clone https://github.com/Zakaria-Kharroub/TaskSphere
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to github**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.
8. **Review**: Once your PR is reviewed and approved, it will be merged into the main branch. Congratulations on your contribution!
</details>

<details closed>
<summary>Contributor Graph</summary>
<br>
<p align="left">
   <a href="https://github.com{/Zakaria-Kharroub/TaskSphere/}graphs/contributors">
      <img src="https://contrib.rocks/image?repo=Zakaria-Kharroub/TaskSphere">
   </a>
</p>
</details>

---

##  License

This project is protected under the [SELECT-A-LICENSE](https://choosealicense.com/licenses) License. For more details, refer to the [LICENSE](https://choosealicense.com/licenses/) file.

---

##  Acknowledgments

- List any resources, contributors, inspiration, etc. here.

---
