<template>
    <div class="userprofile">
        <section>

            <!-- Header Content -->
            <div class="profileheader">
                <section class="hero">
                    <div class="hero-body">
                        <div class="container">
                            <h1 class="title">
                                <b>YOUR PROFILE</b>
                            </h1>
                        </div>
                    </div>
                </section>
            </div>

            <nav class="level">
                <div class="level-item has-text-centered">
                    <div>
                    <p class="heading">Name</p>
                    <p class="title">{{name}}</p>
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                    <p class="heading">Username</p>
                    <p class="title">{{username}}</p>
                    </div>
                </div>
                <div class="level-item has-text-centered">
                    <div>
                    <p class="heading">Email</p>
                    <p class="title">{{email}}</p>
                    </div>
                </div>

                <!-- REMOVE THIS -->
                <div class="level-item has-text-centered">
                    <div>
                    <p class="heading">password->REMOVE</p>
                    <p class="title">{{password}}</p>
                    </div>
                </div>
            </nav>

            <div class="divider"></div>

            <!-- Main table which holds user's info -->
            <div class="userinfo">
                <template>
                    <section>

                        <!-- User's name -->
                        <div class="columns">
                            <div class="column is-three-quarters">
                                <b-input rounded ></b-input>
                            </div>
                            <div class="column">
                                <button class="button is-light" @click="confirmNameChange">
                                    Change name
                                </button>
                            </div>
                        </div>

                        <!-- User's username -->
                        <div class="columns">
                            <div class="column is-three-quarters">
                                <b-input rounded>{{username}}</b-input>
                            </div>
                            <div class="column">
                                <button class="button is-light" @click="confirmUsernameChange">
                                    Change username
                                </button>
                            </div>
                        </div>

                        <!-- User's email -->
                        <div class="columns">
                            <div class="column is-three-quarters">
                                <b-field>
                                    <b-input 
                                        rounded
                                        placeholder="Email"
                                        type="email"
                                        icon="email"
                                        value="test@test.com"
                                        >
                                    </b-input>
                                </b-field>
                            </div>
                            <div class="column">
                                <button class="button is-light" @click="confirmEmailChange">
                                    Change Email
                                </button>
                            </div>
                        </div>

                        <!-- User's password -->
                        <div class="columns">
                            <div class="column is-three-quarters">
                                <b-field>
                                    <b-input rounded value="123" type="password" maxlength="30"></b-input>
                                </b-field>
                            </div>
                            <div class="column">
                                <button class="button is-light" @click="confirmPasswordChange">
                                    Change Password
                                </button>
                            </div>
                        </div>

                        <!-- Section with buttons which have functionality -->
                        <div class="buttonsection">
                            <template>
                                <section>

                                    <b-button class="button is-light" @click="requestPro" id="proBtn" rounded>Become a pro!</b-button>
                                    <b-button class="button is-light" @click="homePage" id="homeBtn" rounded>Home Page</b-button>
                                    <b-button class="button is-light" @click="logout" id="logoutBtn" rounded>Logout</b-button>

                                </section>
                            </template>
                        </div>



                    
                    </section>
                </template>
            </div>

        </section>
    </div>


  
</template>

<script>
export default {
    name: "userprofile",

    components:{

    },

    data(){
        return{
            name: "Firstname Lastname",  //TODO: get name from database
            email: "email@mail.ca", //TODO: get email from database
            username: "user123", //TODO: get username from database
            password: "password" //TODO: get password from database
        }
    },

    methods:{
        confirmNameChange() {
            this.$buefy.dialog.confirm({
                message: 'Confirm name change?',
                onConfirm: () => this.$buefy.toast.open('Name changed')
                //TODO: change name in database
            })
        },
        confirmUsernameChange() {
            this.$buefy.dialog.confirm({
                message: 'Confirm username change?',
                onConfirm: () => this.$buefy.toast.open('Username changed')
                //TODO: change username in database
            })
        },
        confirmEmailChange(){
            this.$buefy.dialog.confirm({
                message: 'Confirm email change?',
                onConfirm: () => this.$buefy.toast.open('Email changed')
                //TODO: change email in database
            })
        },
        confirmPasswordChange(){
            this.$buefy.dialog.confirm({
                message: 'Confirm password change?',
                onConfirm: () => this.$buefy.toast.open('Password changed')
                //TODO: change password in database
            })
        },
        requestPro(){
            //TODO
        },
        homePage(){
            //TODO
        },
        logout(){
            //TODO
        }
    }
};
</script>

<style lang="scss">
@import "../styles/variables.scss";

button{
        width: 100%;
    align-content: center;
    margin-bottom: 5px;
    padding-right: 2px;
}

#logoutBtn{
    width: 30%;
}
#proBtn{
    width: 30%;
}
#homeBtn{
    width: 30%;
}

.userinfo {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 75%;
}

.divider{
    width:5px;
    height:auto;
    display:inline-block;
}

</style>
