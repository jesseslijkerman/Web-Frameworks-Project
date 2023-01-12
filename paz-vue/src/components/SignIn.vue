<template>
<p>Please provide your logon credentials: </p>
  <form @submit.prevent="logIn">

  <label for="email">User e-mail:</label>
  <input v-model="this.email" type="text" name="email">

  <label for="password">Password:</label>
  <input v-model="this.password" type="text" name="password">

    <button>Sign On</button>
  </form>


</template>

<script>
export default {
  name: "SignIn",

  inject: ['sessionService'],

  data() {
    return{
      email: null,
      password: null
    }
  },

  methods: {
    async logIn() {
      await this.sessionService.asyncSignIn(this.email, this.password)
    }
  }
}
</script>

<style scoped>

form{
  margin: auto;
  width: 50%;
}

input[type=text], input[type=number], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

label{
  float: left;
}

button{
  margin: 5px;
}


</style>