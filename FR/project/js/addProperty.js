// add-property.js

document.addEventListener("DOMContentLoaded", function () {
  const form = document.getElementById("propertyForm");
  if (!form) return;

  form.addEventListener("submit", function (e) {
    const propertyName = document.getElementById("propertyName").value.trim();
    const address = document.getElementById("propertyAddress").value.trim();
    const rent = document.getElementById("propertyRent").value.trim();

    if (!propertyName || !address || !rent) {
      alert("Please fill out all fields.");
      e.preventDefault();
      return;
    }

    if (isNaN(rent)) {
      alert("Monthly Rent should be a number.");
      e.preventDefault();
      return;
    }

    // Optional: Confirmation message
    alert("Property added successfully!");
  });
});
