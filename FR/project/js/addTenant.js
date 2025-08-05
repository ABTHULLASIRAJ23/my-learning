// add-tenant.js

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("addTenantForm");
  if (!form) return;

  form.addEventListener("submit", function (e) {
    const name = document.getElementById("tenantName").value.trim();
    const email = document.getElementById("tenantEmail").value.trim();
    const rent = document.getElementById("tenantRent").value.trim();
    const password = document.getElementById("tenantPassword").value.trim();

    if (!name || !email || !rent || !password) {
      alert("Please fill in all fields.");
      e.preventDefault();
      return;
    }

    if (!validateEmail(email)) {
      alert("Please enter a valid email address.");
      e.preventDefault();
      return;
    }

    if (isNaN(rent)) {
      alert("Monthly rent should be a valid number.");
      e.preventDefault();
      return;
    }

    if (password.length < 6) {
      alert("Password must be at least 6 characters long.");
      e.preventDefault();
      return;
    }

    // Optional: Confirmation message
    alert("Tenant added successfully!");
  });

  function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
  }
});
