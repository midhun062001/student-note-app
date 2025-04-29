import { BottomWarning } from "../components/BottomWarning";
import { Button } from "../components/Button";
import { InputBox } from "../components/InputBox";
import { LogHeading } from "../components/LogHeading"
import { LogSubHeading } from "../components/LogSubHeading";

export const SignInPage = () => {
    return (
        <div className="flex min-h-screen items-center justify-center bg-gray-200 px-4 py-12">
            <div className="w-full max-w-md">
                <LogHeading label="Sign in to your account" />
                <LogSubHeading label={"Enter your Sign in Credentials"}/>
                <InputBox label={"Email"} placeholder="Enter your Email" type={"email"} forgetPassword={""}/>
                <InputBox label="Password" placeholder="Enter your Password" type={"password"} forgetPassword={"Forget Password ?"} />
                <Button label={"Sign in"} type={"submit"}/>
                <BottomWarning label={"Don't have an account?"} linkText={"Sign Up"} to={"/signup"} />
            </div>
        </div>
    );
}