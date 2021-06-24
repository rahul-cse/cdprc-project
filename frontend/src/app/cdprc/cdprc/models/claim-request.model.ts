import { OnlineCourses } from "./online-courses.model";

export class ClaimRequest{
    id:number;
    employeeName:string;
    employeeId:string;
    isApproved:boolean;
    onlineCourses:OnlineCourses[];
}