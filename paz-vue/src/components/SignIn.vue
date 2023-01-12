<template>
  <p>Please provide your logon credentials:</p>
  <form @submit.prevent="logIn">

    <label for="email">User e-mail:</label>
    <input v-model="this.email" type="text" id="email">

    <label for="password">Password:</label>
    <input v-model="this.password" type="text" id="password">
    <button>Sign On</button>
  </form>
  <p class="errormessage">{{errorMessage}}</p>
</template>

<script>
export default {
  name: "SignIn",

  inject: ['sessionService'],

  data() {
    return{
      email: null,
      password: null,
      errorMessage: null
    }
  },

  methods: {
    async logIn() {
      this.errorMessage = null
      let account = await this.sessionService.asyncSignIn(this.email, this.password)
      if (account == null){
        this.errorMessage = "Could not authenticate with provided credentials"
      } else {
        this.$router.push("/")
      }
    }
  }
}
</script>

<style scoped>

.errormessage{
  color: darkred;
}

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