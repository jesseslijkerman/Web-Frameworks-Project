<template>
  <div class="navbar">
    <a class="left">Home</a>
    <div class="dropdown">
      <button class="dropbtn">Cabins
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <a>All cabins overview</a>
        <a>Cabins edit (components)</a>
        <a>Cabins edit (routed)</a>
        <a>Cabins edit (managed)</a>
      </div>
    </div>
    <a class="left">Rentals</a>
    <a class="left">My Account</a>
    <a class="right">Sign up</a>
    <a class="right">Log in</a>
  </div>
</template>

<script>
export default {
  name: "NavBar"
}
</script>

<style scoped>
body {
  font-family: Arial, Helvetica, sans-serif;
}

.navbar {
  overflow: hidden;
  background-color: #1a748e;
}

.left{
  float: left;
}

.right{
  float: right;
}

.navbar a {
  font-size: 16px;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

.dropdown {
  float: left;
  overflow: hidden;
}

.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit;
  margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
  background-color: #55c4d7;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  float: none;
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}



</style>