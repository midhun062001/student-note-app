import { useState } from "react";
import { BottomWarning } from "../components/BottomWarning";
import { Button } from "../components/Button";
import { InputBox } from "../components/InputBox";
import { LogHeading } from "../components/LogHeading"
import { LogSubHeading } from "../components/LogSubHeading";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export const SignInPage = () => {
    const[email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const navigate = useNavigate();
    return (
        <div className="flex min-h-screen items-center justify-center bg-gray-200 px-4 py-12">
            <div className="w-full max-w-md border rounded p-3">
                <LogHeading label="Sign in to your account" />
                <LogSubHeading label={"Enter your Sign in Credentials"}/>
                <InputBox label={"Email"} placeholder="Enter your Email" type={"email"} forgetPassword={""}
                onChange = { (e) => setEmail(e.target.value) }
                />
                <InputBox label="Password" placeholder="Enter your Password" type={"password"} forgetPassword={"Forget Password ?"}
                onChange = { (e) => setPassword(e.target.value) }
                />
                <Button 
                    label={"Sign in"} 
                    type={"submit"}
                    onPress={async () => {
                        const response = await axios.post("http://localhost:3000/", {
                            email: email,
                            password: password
                    })
                    if(response.data) {
                        navigate("/home");
                    }
                    }}
                />
                <BottomWarning label={"Don't have an account?"} linkText={"Sign Up"} to={"/signup"} />
            </div>
        </div>
    );
}
