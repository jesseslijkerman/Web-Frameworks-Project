<template>
  <div class="navbar">
    <router-link to="/" class="left">Home</router-link>
    <div class="dropdown">
      <button class="dropbtn">Cabins
        <i class="fa fa-caret-down"></i>
      </button>
      <div class="dropdown-content">
        <router-link to="/overview31">All cabins overview</router-link>
        <router-link to="/overview32">Cabins edit (components)</router-link>
        <router-link to="/overview33">Cabins edit (routed)</router-link>
        <router-link to="/overview34">Cabins edit (managed)</router-link>
        <router-link to="/overview37">Cabins edit (3.7)</router-link>
      </div>
    </div>
    <a class="left">Rentals</a>
    <a class="left">My Account</a>
    <router-link to="/sign-up" class="right">Sign up</router-link>
    <router-link to="/sign-in" class="right">Log in</router-link>
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

.navbar a:hover, .dropdown:hover .dropbtn, .navbar a.active {
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

.dropdown-content a:hover,.dropdown-content a.active {
  background-color: #ddd;
}

.dropdown:hover .dropdown-content {
  display: block;
}



</style>