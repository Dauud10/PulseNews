Pulse News Project

Pulse News is a modern news website built using Vue.js.
The website aggregates news articles and provides a user-friendly interface to interact with the content.
It features a homepage, detailed article pages, admin dashboard for managing content
and various interactive components using the Atomic Design methodology.

1. Setup Instructions
2. Usage
3. Atomic Design Structure
4. User Roles
5. Code Documentation
6. Commit History

7. Setup Instructions
   To get started with the **Pulse News** project, follow the steps below:

install Node.js then install dependencies:

npm install
Run the Development Server

To run the project locally:
npm run serve
Visit http://localhost:8080 in your browser to view the app.

2. Usage
   Pulse News is an interactive news website with various features:

Homepage: Displays articles and allows users to click on "Read More" to view the full article.

Article Detail Page: Shows detailed content for each article.

Admin Dashboard: Allows admin users to manage articles (CRUD functionality).

Login Page: Provides login functionality for users to access admin content.
Key User Actions:
Admin: Can log in and manage articles (edit, update, delete).

Regular User: Can read articles, use the search bar, and navigate through the website.

3. Atomic Design Structure
   The project follows Atomic Design

Atoms: Basic building blocks like buttons, inputs, icons Button.vue, Input.vue

Molecules: Combined atoms to form more complex UI elements SearchBar.vue, Card.vue

Organisms: Complex UI components composed of molecules Navbar.vue, Footer.vue

Pages: Complete pages that make up the application's content Home.vue, ArticleDetail.vue

Templates: Not used directly in this project; templates are essentially page layouts that define the structure.

4. User Roles
   Admin: Can log in to the admin dashboard and manage articles. Admins can:

Create Articles: Add new articles.
Edit Articles: Modify existing articles.
Delete Articles: Remove articles.
User: Regular visitors who can:
View Articles: Browse through articles on the homepage.
View Article Detail: Read full articles.
Search Articles: Use the search bar to find specific articles.

5. Code Documentation
   CRUD Functions:
   In the admin dashboard, the article management system implements CRUD functionality. Example for adding a new article:

Edit: Edits all articles in the list.
Read: Displays article details when selected.
Update: Allows modification of an article's content.
Delete: Removes an article from the list.

6. Commit History
   I have not commited anything it did not work.

Initial Setup: Setup Vue project with default template.

Added Basic Components: Created basic components like Button.vue and Input.vue.

Implemented Navbar: Designed the Navbar component.

Created Admin Dashboard: Added functionality to manage articles.

CRUD Operations for Articles: Implemented create, update, delete operations.

Article Detail Page: Implemented the article detail page.

Added User Authentication: Created login functionality for admin.

Styled Homepage: Updated homepage design to match the Figma wireframe.
