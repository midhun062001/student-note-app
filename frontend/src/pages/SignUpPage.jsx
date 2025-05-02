import { useState } from "react";
import { InputBox } from "../components/InputBox";
import { LogHeading } from "../components/LogHeading";
import { LogSubHeading } from "../components/LogSubHeading";
import { Button } from "../components/Button";
import { useNavigate } from "react-router-dom";
import { BottomWarning } from "../components/BottomWarning";
import axios from "axios";

export const SignUpPage = () => {
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [userName, setUserName] = useState("");
    const [mobileNumber, setMobileNumber] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();

    return (
        <div className="min-h-screen flex justify-center bg-gray-400">
            <div className="flex flex-col justify-center">
                <div className="max-w-md rounded-lg border px-4 p-2 bg-gray-200">
                    <LogHeading label={"Signup"}/>
                    <LogSubHeading label={"Enter your information to create an account"} />
                    <div className="flex flex-row justify-center">
                    <InputBox 
                        label={"First Name"}
                        placeholder={"Enter your first name"}
                        type={"text"}
                        forgetPassword={""}
                        onChange = {(e) => {setFirstName(e.target.value);} }
                    />
                    <InputBox
                        label={"Last Name"}
                        placeholder={"Enter your last name"}
                        type={"text"}
                        forgetPassword={""}
                        onChange = {(e) => {setLastName(e.target.value);}}
                    />
                    </div>
                    <InputBox
                        label={"Username"}
                        placeholder={"Enter your username"}
                        type={"text"}
                        forgetPassword={""}
                        onChange = {(e) => {setUserName(e.target.value);}}
                    />
                    <InputBox
                        label={"Mobile Number"}
                        placeholder={"9361811916"}
                        type={"number"}
                        forgetPassword={""}
                        onChange = {(e) => {setMobileNumber(e.target.value);}}
                    />
                    <InputBox
                        label={"Email"}
                        placeholder={"example@gmail.com"}
                        type={"email"}
                        forgetPassword={""}
                        onChange = {(e) => {setEmail(e.target.value);}}
                    />
                    <InputBox
                        label={"Password"}
                        placeholder={"********"}
                        type={"password"}
                        forgetPassword={""}
                        onChange = {(e) => {setPassword(e.target.value);}}
                    />
                    <Button
                        label={"Sign Up"}
                        type={"submit"}
                        onPress=
                        {async () => {
                            try { //Add backend route
                                const response = await axios.post("backendConnection" , {
                                    firstName,
                                    lastName,
                                    userName,
                                    mobileNumber,
                                    email,
                                    password
                                });
                                console.log("Response Data : ", response.data);

                                if(response.data) {
                                    navigate("/dashbord");
                                } else {
                                    console.log("Error in response data");
                                }

                            } catch (error) {
                                console.log("Error during signup : ", error);
                            }
                        }}
                    />
                    <BottomWarning
                        label={"Already have an account?"}
                        linkText={"Sign in"}
                        to={"/signin"}
                    />
                </div>
            </div>
        </div>
    );
}

