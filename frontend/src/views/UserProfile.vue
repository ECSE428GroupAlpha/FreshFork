<template>
    <div class="userprofile">
        <div class="userinfo">
            <template>
                <section>

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


                    <div class="columns">
                         <div class="column is-three-quarters">
                            <b-input
                            rounded 
                            icon="view-dashboard"
                            placeholder="Enter a new name"
                            v-model="newName"
                            ></b-input>
                        </div>
                        <div class="column">
                            <button class="button is-light" @click="confirmNameChange(newName)">
                                Change Name {{this.newName}}
                            </button>
                        </div>
                    </div>


                    <div class="columns">
                         <div class="column is-three-quarters">
                            <b-input
                            rounded 
                            icon="account"
                            placeholder="Enter a new username"
                            v-model="newUsername"
                            ></b-input>
                        </div>
                        <div class="column">
                            <button class="button is-light" @click="confirmUsernameChange(newUsername)">
                                Change Username {{this.newUsername}}
                            </button>
                        </div>
                    </div>


                    <div class="columns">
                         <div class="column is-three-quarters">
                            <b-input
                            rounded
                            type="email"
                            icon="email"
                            placeholder="Enter a new email"
                            v-model="newEmail"
                            ></b-input>
                        </div>
                        <div class="column">
                            <button class="button is-light" @click="confirmEmailChange(newEmail)">
                                Change Email {{this.newEmail}}
                            </button>
                        </div>
                    </div>


                    <div class="columns">
                         <div class="column is-three-quarters">
                            <b-input
                            rounded
                            type="password"
                            placeholder="Enter a new password"
                            v-model="newPassword"
                            password-reveal
                            ></b-input>
                        </div>
                        <div class="column">
                            <button class="button is-light" @click="confirmPasswordChange(newPassword)">
                                Change Password {{this.newPassword}}
                            </button>
                        </div>
                    </div>

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
    </div>
</template>


<script>
export default {
    name: "userprofile",

    components:{

    },

    data(){
        return{
            newName: "",
            newUsername: "",
            newEmail: "",
            newPassword: "",
            name:"first last",          //TODO: backend backend backend
            username: "uname123",
            email: "email@email.ca",
            password: "123pass"
        }
    },

    methods:{
        confirmNameChange(input){
            //TODO: verify input
            if(input != null){
                alert(input);
                //username = input;   //TODO: Set username in back-end
            }
            this.$buefy.dialog.confirm({
                message: 'Confirm name change?',
                onConfirm: () => this.$buefy.toast.open('Name changed')
                //TODO: change name in database
            });        
        },
        confirmUsernameChange(input){
            //TODO: verify input
            if(input != null){
                alert(input);
            }
            this.$buefy.dialog.confirm({
                message: 'Confirm username change?',
                onConfirm: () => this.$buefy.toast.open('Username changed')
                //TODO: change name in database
            });        
        },
        confirmEmailChange(input){
            //TODO: verify input
            if(input != null){
                alert(input);
            }
            this.$buefy.dialog.confirm({
                message: 'Confirm username change?',
                onConfirm: () => this.$buefy.toast.open('Email changed')
                //TODO: change name in database
            });        
        },
        confirmPasswordChange(input){
            //TODO: verify input
            if(input != null){
                alert(input);
            }
            this.$buefy.dialog.confirm({
                message: 'Confirm password change?',
                onConfirm: () => this.$buefy.toast.open('Password changed')
                //TODO: change name in database
            });        
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
        // submitTutor(tutorName) {
        //     this.$router.push({
        //     name: "TutorReviews",
        //     params: { tutorName: tutorName }
        //     });
        //  },
    }
};
</script>



<style lang="scss">
@import "../styles/variables.scss";

#testBtn{
    width:25%;
}

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
