# Studio Project: Tic-Tac-Toe

A digital rendition of the classic Tic-Tac-Toe game designed to demonstrate mastery over the software engineering lifecycle, automated project management infrastructure, and continuous integration/deployment protocols.

*Public Repository URL:* https://github.com/whoisham/technikum-SLT-tic-tac-toe.git

---

## 1. Software Engineering Lifecycle Methodology

### 1.1 Automated Kanban Board Workflow
Our studio implemented a fully automated project management matrix via GitHub Projects. Transitions between stages are automated based on repository activity:
* *Todo:* Contains the user story backlog with unique identifiers (US-01 to US-04).
* *In Progress:* Activated when a developer assigns a user story. Branch creation is initiated directly via the GitHub UI card options.
* *In Review:* Automated state triggered immediately upon opening a Pull Request (PR) from a feature branch to main.
* *Done:* Automated state reached once structural checks pass and the PR is successfully merged.

### 1.2 Git Workflow & Branch Protection
Direct commits to the main branch are blocked via branch protection guardrails. Code integration follows this sequence:
1. Branch Generation: Spin up a branch via the target GitHub User Story Issue (feature/US-xx-...) on the website dashboard.
2. Local Sync: Fetch and checkout the remote tracking branch locally by running: git fetch origin && git checkout feature/YOUR-BRANCH-NAME
3. Local Iteration: Write code inside IntelliJ matching the technical specification design matrix.
4. PR Verification: Push modifications to remote and open a PR to trigger the automated CI check pipeline.

---

## 2. Technical Architecture Specification

The system architecture mirrors the required class diagram structural design blueprint, shifting game loop coordination to a dedicated controller instance and maintaining primitive data layers.

The system consists of three main components:
* TicTacToe: The main controller class handling the core game loop, turn tracking (player1, player2, currentPlayer), winner evaluation (hasWinner), and game initialization (start).
* Board: Manages the structural primitive grid tracking layout via a 2D char array (cells). It controls cell state validation (isCellEmpty), marker placement (place), clearing functions (clear), full validation (isFull), and text rendering (print).
* Player: An immutable data container managing the structural turn token data (marker).

---

## 3. CI/CD Automated Build & Release Pipeline

Our workflow automates code verification and release management via GitHub Actions using JDK 25 (Temurin):

* Continuous Integration (On: Push / PR): Compiles the source files and triggers the JUnit 5 execution runtime matrix (mvn test) across all feature branches.
* Continuous Delivery (On: Merge to main):
1. Dynamically alters the internal Maven metadata structure version ID tag inside pom.xml to match the exact automated run build tag version sequence (1.0.RUN_NUMBER) using the mvn versions:set command.
2. Compiles, tests, and packages the solution into an optimized standalone deployment archive package binary file (.jar).
3. Generates a public, production-grade GitHub Release tag (v1.0.RUN_NUMBER) and links the compiled download binary asset directly to the version changelog page automatically.

---

## 4. Quality Assurance and Matrix Testing Compliance

Every business logic method is evaluated using at least two independent unit tests covering positive execution tracks, negative error path validations, and out-of-bounds boundary conditions.

* isCellEmpty() (Positive Case): Confirms unused cells return true.
* isCellEmpty() (Negative Case): Confirms cells occupied with a marker track return false.
* isCellEmpty() (Edge Case): Validates out-of-bounds negative or overly large index bounds return false instead of throwing exceptions.
* place() (Edge Case): Confirms out-of-bounds inputs are safely ignored without terminal array failure.
* isFull() (Positive Case): Returns true only when all grid sectors are filled.
* isFull() (Edge Case): Ensures returns false if exactly one cell remains empty.
* clear() (Positive Case): Guarantees all sectors clear cleanly back to empty characters.

---

## 5. Development Workspace Quickstart

### Setup & Compilation
To compile the architecture and execute the localized test cases inside your terminal environment, execute the following commands:

* Execute unit testing suite: mvn test
* Locally package clean