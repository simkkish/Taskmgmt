package taskmgmt

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import taskmgmt.enums.TaskStatus

@Transactional
@Secured(['Role'])

class InitializationService {

    Random rand = new Random()


    void initTask() {
        for (int i; i < 5; i++) {
            new Task(taskStatus: TaskStatus.ASSIGNED, title: TaskType.findById(rand.nextInt((int) TaskType.list().size()) + 1).title, detail: TaskType.findById(rand.nextInt((int) TaskType.list().size()) + 1).description,
                    user: User.findById(rand.nextInt((int) User.list().size()) + 1), taskType: TaskType.findById(rand.nextInt((int) TaskType.list().size()) + 1),
                    dateCreated: new Date(), customer: Customer.findById(rand.nextInt((int) Customer.list().size()) + 1), dueDate: new Date()).save()

        }
    }

    void initTaskType() {

        new TaskType(title: "Watch Netflix", description: "Binge watch and waste time").save()
        new TaskType(title: "Hulu is Life", description: "Next episode of family guy is out").save()
        new TaskType(title: "Crush the CrunchyRoll", description: "Anime is not cartoon").save()
        new TaskType(title: "Life of Prime", description: "Download now watch months later.").save()
        new TaskType(title: "Scan the Document", description: "Scan all the received document").save()
        new TaskType(title: "Call customer", description: "Call all the customer who left the voicemail").save()
        new TaskType(title: "Receive mail", description: "Receive the mail from the mail center").save()
        new TaskType(title: "Respond the email", description: "Responding all the email to customer who inqury about the product").save()
        new TaskType(title: "Organizing meeting", description: "Organizing weekly meeting to get the status of the work").save()
        new TaskType(title: "Allocate the budget", description: "Assigning the budget on the basis of the spent amount").save()

    }

    void initUserRole() {
        //creating the role
        Role adminRole = new Role(authority: 'ROLE_ADMIN').save()
        Role userRole = new Role(authority: 'ROLE_USER').save()
        Role managerRole = new Role(authority: 'ROLE_MANAGER').save()

        //creating user
        User adminUser = new User(username: 'admin', password: 'admin', enabled: true).save()
        User managerUser = new User(username: 'manager', password: 'mgmt', enabled: true).save()
        User userUser = new User(username: 'user', password: 'user', enabled: true).save()

        //assigning role to the user
        UserRole.create(adminUser, adminRole)
        UserRole.create(userUser, userRole)
        UserRole.create(managerUser, managerRole)
    }

    String[] firstName = ["Budz", "Pain", "Konan", "Nagato", "Itachi", "Tobi", "Madara", "Naruto", "Danzou", "Kakashi", "Kerry", "Edward", "Florentino", "Melda", "Jamee", "Jeffrey", "Jerilyn", "Fatima", "Albertina", "Gregoria", "Kellee", "Garnett",
                          "Shawana", "Kasha", "Florinda", "Bev", "Amberly", "Karrie", "Malorie", "Richard", "Fatimah", "Asa", "Lanita", "Mariela", "Serina",
                          "Georgann", "Christoper", "Eliana", "Malcolm", "Lisette", "Pamelia", "Lorita", "Glynda", "Patience", "Rachael", "Homer", "Kamilah",
                          "Alida", "Mayola", "Mervin", "Jeremy", "Selene", "Dominica", "Alexandria", "Verona", "Margene", "Tanner", "Sherrill", "Julia", "Oswaldo"]
    String[] lastName = ["Mcgee", "Conner", "Marsh", "Alvarez", "Robbins", "Sanford", "Hancock", "Howard", "Robles", "Bartlett", "Marshall", "Maddox", "Shields",
                         "Bradford", "Short", "Black", "Nielsen", "Cisneros", "Berry", "Austin", "Murray", "Sullivan", "Miller", "Jordan",
                         "Richardson", "Barton", "Juarez", "Wiggins", "Duran", "Frazier", "Villa", "Stone",
                         "Andrade", "Francis", "Johns", "Warren", "Russo", "Ray", "Roberts", "Torres", "Patel", "Miles", "Thornton", "Horne", "Lozano",
                         "Wallace", "Holmes", "Hahn", "Moran", "Merritt", "Case", "Tanner", "Gray", "Ellison", "Larsen", "Gonzales", "Rice", "Turner"]
    String[] address = ["777 Brockton Avenue, Abington MA 2351",
                        "30 Memorial Drive, Avon MA 2322",
                        "250 Hartford Avenue, Bellingham MA 2019",
                        "700 Oak Street, Brockton MA 2301",
                        "66-4 Parkhurst Rd, Chelmsford MA 1824",
                        "591 Memorial Dr, Chicopee MA 1020",
                        "55 Brooksby Village Way, Danvers MA 1923",
                        "137 Teaticket Hwy, East Falmouth MA 2536",
                        "42 Fairhaven Commons Way, Fairhaven MA 2719",
                        "374 William S Canning Blvd, Fall River MA 2721",
                        "121 Worcester Rd, Framingham MA 1701",
                        "677 Timpany Blvd, Gardner MA 1440",
                        "337 Russell St, Hadley MA 1035",
                        "295 Plymouth Street, Halifax MA 2338",
                        "1775 Washington St, Hanover MA 2339",
                        "280 Washington Street, Hudson MA 1749",
                        "20 Soojian Dr, Leicester MA 1524",
                        "11 Jungle Road, Leominster MA 1453",
                        "301 Massachusetts Ave, Lunenburg MA 1462",
                        "780 Lynnway, Lynn MA 1905",
                        "70 Pleasant Valley Street, Methuen MA 1844",
                        "830 Curran Memorial Hwy, North Adams MA 1247",
                        "1470 S Washington St, North Attleboro MA 2760",
                        "506 State Road, North Dartmouth MA 2747",
                        "742 Main Street, North Oxford MA 1537",
                        "72 Main St, North Reading MA 1864",
                        " 200 Otis Street, Northborough MA 1532",
                        "180 North King Street, Northhampton MA 1060",
                        "555 East Main St, Orange MA 1364",
                        "555 Hubbard Ave-Suite 12, Pittsfield MA 1201",
                        "300 Colony Place, Plymouth MA 2360",
                        "301 Falls Blvd, Quincy MA 2169",
                        "36 Paramount Drive, Raynham MA 2767",
                        "450 Highland Ave, Salem MA 1970",
                        "1180 Fall River Avenue, Seekonk MA 2771",
                        "1105 Boston Road, Springfield MA 1119",
                        "100 Charlton Road, Sturbridge MA 1566",
                        "262 Swansea Mall Dr, Swansea MA 2777",
                        "333 Main Street, Tewksbury MA 1876",
                        "550 Providence Hwy, Walpole MA 2081",
                        "352 Palmer Road, Ware MA 1082",
                        "3005 Cranberry Hwy Rt 6 28, Wareham MA 2538",
                        " 250 Rt 59, Airmont NY 10901",
                        " 141 Washington Ave Extension, Albany NY 12205",
                        "13858 Rt 31 W, Albion NY 14411",
                        "2055 Niagara Falls Blvd, Amherst NY 14228",
                        "101 Sanford Farm Shpg Center, Amsterdam NY 12010",
                        "297 Grant Avenue, Auburn NY 13021",
                        "4133 Veterans Memorial Drive, Batavia NY 14020",
                        "6265 Brockport Spencerport Rd, Brockport NY 14420",
                        "5399 W Genesse St, Camillus NY 13031",
                        "3191 County rd 10, Canandaigua NY 14424",
                        "30 Catskill, Catskill NY 12414",
                        "161 Centereach Mall, Centereach NY 11720",
                        "3018 East Ave, Central Square NY 13036",
                        "100 Thruway Plaza, Cheektowaga NY 14225",
                        "8064 Brewerton Rd, Cicero NY 13039",
                        "5033 Transit Road, Clarence NY 14031",
                        "3949 Route 31, Clay NY 13041",
                        "139 Merchant Place, Cobleskill NY 12043"]
    String[] email = ["johnh@outlook.com", "mrobshaw@gmail.com", "report@yahoo.com", "sjava@me.com", "gravyface@yahoo.com", "enintend@yahoo.com",
                      "bancboy@icloud.com", "malin@hotmail.com", "monopole@aol.com", "andrewik@yahoo.ca", "carmena@yahoo.ca", "sarahs@outlook.com",
                      "bjoern@icloud.com", "iapetus@gmail.com", "osaru@icloud.com", "nanop@sbcglobal.net", "njpayne@mac.com", "goresky@sbcglobal.net",
                      "euice@optonline.net", "chaikin@verizon.net", "mcrawfor@gmail.com", "fbriere@outlook.com", "mschwartz@verizon.net", "jsnover@yahoo.com",
                      "tokuhirom@outlook.com", "keijser@outlook.com", "barlow@live.com", "bwcarty@msn.comhager@mac.com", "skoch@yahoo.com", "chronos@sbcglobal.net",
                      "niknejad@live.com", "amichalo@outlook.com", "studyabr@verizon.net", "shang@icloud.com", "devphil@msn.com", "kenja@outlook.com",
                      "fallorn@optonline.net", "jshirley@verizon.net", "kildjean@verizon.net", "sassen@yahoo.ca", "geekgrl@optonline.net", "gtaylor@optonline.net",
                      "bester@yahoo.ca", "mcrawfor@yahoo.com", "daveed@comcast.net", "carroll@sbcglobal.net", "starstuff@outlook.com", "temmink@icloud.com",
                      "matsn@icloud.com", "mcast@me.com", "mrsam@hotmail.com", "jguyer@outlook.com", "luebke@verizon.net", "dalamb@mac.com", "research@hotmail.com",
                      "ryanshaw@live.com", "fluffy@live.com", "dmiller@icloud.com", "jdhedden@att.net"]

    String[] comments = ["It has priority deadline. Please complete this on time.", "This customer is our regular client so try to complete this even before deadline.",
                         "I see a typo in the deadline. Please make sure it's the right one.",
                         "The customer related to this task has requested to cancel this task. So, this task needs to be deleted."
                         , "Good work. Keep it up.", "If you need help with this task, please let me know.", "How's the task going so far?", "How long before you can complete this?",
                         "Can you please finish this by tomorrow if possible?", "Please make sure all the related files are checked before you complete this task.",
                         "What is the earliest date you can finish this?", "Good job!", "Please don't forget to comment on your codes :-)",
                         "I'm so glad you are undertaking this task on your own. I have great hopes from you.", "The best person suited for this task :)",
                         "Can you please provide the report of the progress so far?"]

    void initCustomer() {

        for (int i; i < 50; i++) {
            new Customer(firstName: firstName[i], lastName: lastName[i], address: address[i],
                    email: email[i], phoneNumber: 123456789, dateCreated: new Date()).save()
        }
    }

    void initComment() {
        for (int i; i < 20; i++) {
            Task task = Task.findById(rand.nextInt((int) Task.list().size()) + 1)
            new Comment(content: comments[rand.nextInt((int) comments.length)], dateCreated: new Date(), task: task,
                    user: User.findById(rand.nextInt((int) User.list().size()) + 1)).save()
        }
    }
}
