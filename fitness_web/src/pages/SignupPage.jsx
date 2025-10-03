import { useState } from "react";
import Button from "../components/Button";
import Header from "../components/Header";
import Hyperlink from "../components/Hyperlink";
import InputMainPage from "../components/specifics/InputMainPage";
import ApiUtils from "../utils/ApiUtils";

export default function SignupPage() {
    const [name, setName] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const invalidCredentials = (message) => {
        console.error(message);
    };

    const handleSignUp = async () => {
        if (!name || !phoneNumber || !password || !confirmPassword) {
            invalidCredentials("All fields are required");
            return;
        }
        if (password !== confirmPassword) {
            invalidCredentials("Passwords do not match");
            return;
        }

        const res = await ApiUtils.Fetch("/api/v1/user", {
            method: "POST",
            body: JSON.stringify({
                name,
                phoneNumber,
                password
            })
        });


    };

    return (
        <div className="w-screen h-screen pb-25 flex flex-col gap-8 items-center justify-center">
            <Header text="Sign Up" style="text-7xl mb-10" />

            <InputMainPage placeholder="Name..." value={name} onChange={(e) => setName(e.target.value)} />
            <InputMainPage placeholder="Phone Number..." value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
            <InputMainPage placeholder="Password..." type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
            <InputMainPage placeholder="Renter Password..." type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} />

            <Button
                text="Sign Up"
                style="text-3xl bg-blue-500 px-20 py-3 font-bold text-white rounded-lg"
                onClick={handleSignUp}
            />

            <Hyperlink text={"Have an account? Log in :)"} href={"/login"} />
        </div>
    );
}
