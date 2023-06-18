drop table if exists notifications;
drop table if exists user_notifications;
drop table if exists articles;
drop table if exists class_instructors;
drop table if exists classes;
drop table if exists course;
drop table if exists enrollments;
drop table if exists instructors;
drop table if exists lectures;
drop table if exists lessons;
drop table if exists notes;
drop table if exists quizzes;
drop table if exists users;

CREATE TABLE users
(
    id           INTEGER PRIMARY KEY,
    first_name   TEXT,
    last_name    TEXT,
    gender       TEXT,
    dob          DATE,
    student_code TEXT,
    address      TEXT,
    hometown     TEXT,
    avatar       TEXT,
    religion     TEXT NULL,
    ethnicity    TEXT,
    citizen_id   TEXT
);
INSERT INTO users VALUES(1,'Nguyễn','Văn A','Male','2000/03/15','1','Hà Nội','Hà Nội','user_avatar/avatar1.jpg',NULL,'Kinh','123456789012');
INSERT INTO users VALUES(2,'Trần','Thị B','Female','1999/05/28','2','Hải Phòng','Hải Phòng','user_avatar/avatar2.jpg',NULL,'Kinh','123456789013');
INSERT INTO users VALUES(3,'Lê','Văn C','Female','2001/11/02','3','Bắc Ninh','Bắc Ninh','user_avatar/avatar3.jpg',NULL,'Kinh','123456789014');
INSERT INTO users VALUES(4,'Phạm','Thị D','Female','1998/08/10','4','Hà Nam','Hà Nam','user_avatar/avatar4.jpg',NULL,'Kinh','123456789015');
INSERT INTO users VALUES(5,'Nguyễn','Văn E','Male','2002/01/20','5','Hải Dương','Hải Dương','user_avatar/avatar5.jpg',NULL,'Kinh','123456789016');
INSERT INTO users VALUES(6,'Trần','Thị F','Female','2003/06/07','6','Bắc Giang','Bắc Giang','user_avatar/avatar6.jpg',NULL,'Kinh','123456789017');
INSERT INTO users VALUES(7,'Lê','Văn G','Male','2000/04/25','7','Hà Tây','Hà Tây','user_avatar/avatar7.jpg',NULL,'Kinh','123456789018');
INSERT INTO users VALUES(8,'Phạm','Thị H','Female','1999/07/12','8','Hải Hưng','Hải Hưng','user_avatar/avatar8.jpg',NULL,'Kinh','123456789019');
INSERT INTO users VALUES(9,'Nguyễn','Văn I','Male','2001/12/30','9','Bắc Ninh','Bắc Ninh','user_avatar/avatar9.jpg',NULL,'Kinh','123456789020');
INSERT INTO users VALUES(10,'Trần','Thị K','Female','1998/09/18','10','Hải Phòng','Hải Phòng','user_avatar/avatar1.jpg',NULL,'Kinh','123456789021');
CREATE TABLE instructors

(

    id           INTEGER PRIMARY KEY,

    name         TEXT,

    avatar       TEXT,

    phone_number TEXT

);
INSERT INTO instructors VALUES(1,'Lê Thị A','user_avatar/avatar1.jpg','0123456789');
INSERT INTO instructors VALUES(2,'Nguyễn Văn B','user_avatar/avatar2.jpg','0987654321');
INSERT INTO instructors VALUES(3,'Trần Thị C','user_avatar/avatar3.jpg','0369852147');
INSERT INTO instructors VALUES(4,'Phạm Đình D','user_avatar/avatar4.jpg','0932145678');
INSERT INTO instructors VALUES(5,'Võ Thị E','user_avatar/avatar5.jpg','0778642913');
INSERT INTO instructors VALUES(6,'Hoàng Văn F','user_avatar/avatar6.jpg','0846231579');
INSERT INTO instructors VALUES(7,'Trịnh Thị G','user_avatar/avatar7.jpg','0912374568');
INSERT INTO instructors VALUES(8,'Đặng Văn H','user_avatar/avatar8.jpg','0857394612');
INSERT INTO instructors VALUES(9,'Lý Thị I','user_avatar/avatar9.jpg','0975432198');
INSERT INTO instructors VALUES(10,'Ngô Văn K','user_avatar/avatar10.jpg','0824163579');
CREATE TABLE course

(

    id                      INTEGER PRIMARY KEY,

    name                    TEXT,

    course_code             TEXT,

    course_load_theoretical INTEGER,

    course_load_practical   INTEGER

);
INSERT INTO course VALUES(1,'Tiếng Anh Công nghệ thông tin cơ bản 1','FL6085',2,0);
INSERT INTO course VALUES(2,'Tiếng Anh công nghệ thông tin cơ bản 2','FL6086',2,0);
INSERT INTO course VALUES(3,'Tiếng Anh Công nghệ thông tin cơ bản 3','FL6087',2,0);
INSERT INTO course VALUES(4,'Tiếng Anh Công nghệ thông tin cơ bản 4','FL6088',2,0);
INSERT INTO course VALUES(5,'Tiếng Anh Công nghệ thông tin cơ bản 5','FL6089',2,0);
INSERT INTO course VALUES(6,'Chủ nghĩa xã hội khoa học','LP6012',2,0);
INSERT INTO course VALUES(7,'Kinh tế chính trị Mác-Lênin','LP6011',2,0);
INSERT INTO course VALUES(8,'Lịch sử Đảng Cộng sản Việt Nam','LP6013',2,0);
INSERT INTO course VALUES(9,'Triết học Mác-Lênin','LP6010',3,0);
INSERT INTO course VALUES(10,'Tư tưởng Hồ Chí Minh','LP6004',2,0);
INSERT INTO course VALUES(11,'Pháp luật đại cương','LP6003',2,0);
INSERT INTO course VALUES(12,'Đại số tuyến tính','BS6001',3,0);
INSERT INTO course VALUES(13,'Giải tích','BS6002',3,0);
INSERT INTO course VALUES(14,'Nhập môn lập trình máy tính','IT6027',2,1);
INSERT INTO course VALUES(15,'Toán rời rạc','IT6035',3,0);
INSERT INTO course VALUES(16,'Công tác quốc phòng, an ninh','DC6001',2,0);
INSERT INTO course VALUES(17,'Đường lối quân sự của Đảng','DC6002',3,0);
INSERT INTO course VALUES(18,'QS chung và CTKT bắn súng TLAK (CKC)','DC6003',0,3);
INSERT INTO course VALUES(19,'An toàn và bảo mật thông tin','IT6001',2,0);
INSERT INTO course VALUES(20,'Cấu trúc dữ liệu và giải thuật','IT6002',2,1);
INSERT INTO course VALUES(21,'Cơ sở dữ liệu','IT6006',3,0);
INSERT INTO course VALUES(22,'Hệ quản trị cơ sở dữ liệu','IT6012',2,1);
INSERT INTO course VALUES(23,'Kiến trúc máy tính','IT6014',3,0);
INSERT INTO course VALUES(24,'Kỹ thuật lập trình','IT6015',2,1);
INSERT INTO course VALUES(25,'Lập trình hướng đối tượng','IT6018',2,1);
INSERT INTO course VALUES(26,'Mạng máy tính','IT6023',2,0);
INSERT INTO course VALUES(27,'Nguyên lý hệ điều hành','IT6025',2,0);
INSERT INTO course VALUES(28,'Nhập môn Công nghệ phần mềm','IT6026',2,1);
INSERT INTO course VALUES(29,'Nhập môn về kỹ thuật','IT6011',2,0);
INSERT INTO course VALUES(30,'Phân tích và đặc tả yêu cầu phần mềm','IT6031',2,1);
INSERT INTO course VALUES(31,'Quản lý dự án công nghệ thông tin','IT6033',2,0);
INSERT INTO course VALUES(32,'Thiết kế phần mềm','IT6038',2,1);
INSERT INTO course VALUES(33,'Thiết kế Web','IT6039',3,0);
INSERT INTO course VALUES(34,'Thực tập cơ sở ngành','IT6040',0,0);
INSERT INTO course VALUES(35,'Trí tuệ nhân tạo','IT6043',3,0);
INSERT INTO course VALUES(36,'Đảm bảo chất lượng phần mềm','IT6008',2,0);
INSERT INTO course VALUES(37,'Kiểm thử phần mềm','IT6013',2,0);
INSERT INTO course VALUES(38,'Lập trình .NET','IT6017',2,1);
INSERT INTO course VALUES(39,'Lập trình Java','IT6019',2,1);
INSERT INTO course VALUES(40,'Một số công nghệ phát triển phần mềm','IT6024',2,1);
INSERT INTO course VALUES(41,'Thực tâp chuyên ngành Kỹ thuật phần mềm','IT6041',0,0);
INSERT INTO course VALUES(42,'Đồ án tốt nghiệp (Kỹ thuật phần mềm)','IT6009',0,0);
INSERT INTO course VALUES(43,'Thực tập doanh nghiệp (Kỹ thuật phần mềm)','IT6042',0,0);
INSERT INTO course VALUES(44,'Tiếng Hàn cơ bản 1','FL6287',2,0);
INSERT INTO course VALUES(45,'Tiếng Hàn cơ bản 2','FL6288',2,0);
INSERT INTO course VALUES(46,'Tiếng Hàn cơ bản 3','FL6289',2,0);
INSERT INTO course VALUES(47,'Tiếng Hàn cơ bản 4','FL6290',2,0);
INSERT INTO course VALUES(48,'Tiếng Hàn cơ bản 5','FL6291',2,0);
INSERT INTO course VALUES(49,'Tiếng Nhật cơ bản 1','FL6292',2,0);
INSERT INTO course VALUES(50,'Tiếng Nhật cơ bản 2','FL6293',2,0);
INSERT INTO course VALUES(51,'Tiếng Nhật cơ bản 3','FL6294',2,0);
INSERT INTO course VALUES(52,'Tiếng Nhật cơ bản 4','FL6295',2,0);
INSERT INTO course VALUES(53,'Tiếng Nhật cơ bản 5','FL6296',2,0);
INSERT INTO course VALUES(54,'Tiếng Trung cơ bản 1','FL6282',2,0);
INSERT INTO course VALUES(55,'Tiếng Trung cơ bản 2','FL6283',2,0);
INSERT INTO course VALUES(56,'Tiếng Trung cơ bản 3','FL6284',2,0);
INSERT INTO course VALUES(57,'Tiếng Trung cơ bản 4','FL6285',2,0);
INSERT INTO course VALUES(58,'Tiếng Trung cơ bản 5','FL6286',2,0);
INSERT INTO course VALUES(59,'Kinh tế học đại cương','BM6001',2,0);
INSERT INTO course VALUES(60,'Tác phong làm việc chuyên nghiệp','ME6060',2,0);
INSERT INTO course VALUES(61,'Tiếng Anh Công nghệ thông tin','FL6090',2,0);
INSERT INTO course VALUES(62,'Tiếng Hàn','FL6297',2,0);
INSERT INTO course VALUES(63,'Tiếng Nhật','FL6104',2,0);
INSERT INTO course VALUES(64,'Tiếng Trung','FL6105',2,0);
INSERT INTO course VALUES(65,'Tối ưu hóa','IT6036',3,0);
INSERT INTO course VALUES(66,'Xác suất thống kê','BS6008',3,0);
INSERT INTO course VALUES(67,'Aerobic 1','PE6001',0,1);
INSERT INTO course VALUES(68,'Aerobic 2','PE6002',0,1);
INSERT INTO course VALUES(69,'Bơi 1','PE6005',0,1);
INSERT INTO course VALUES(70,'Bơi 2','PE6006',0,1);
INSERT INTO course VALUES(71,'Bóng bàn 1','PE6017',0,1);
INSERT INTO course VALUES(72,'Bóng bàn 2','PE6018',0,1);
INSERT INTO course VALUES(73,'Bóng chuyền 1','PE6003',0,1);
INSERT INTO course VALUES(74,'Bóng chuyền 2','PE6004',0,1);
INSERT INTO course VALUES(75,'Bóng đá 1','PE6027',0,1);
INSERT INTO course VALUES(76,'Bóng đá 2','PE6028',0,1);
INSERT INTO course VALUES(77,'Bóng rổ 1','PE6021',0,1);
INSERT INTO course VALUES(78,'Bóng rổ 2','PE6022',0,1);
INSERT INTO course VALUES(79,'Cầu lông 1','PE6025',0,1);
INSERT INTO course VALUES(80,'Cầu lông 2','PE6026',0,1);
INSERT INTO course VALUES(81,'Cầu mây 1','PE6031',0,1);
INSERT INTO course VALUES(82,'Cầu mây 2','PE6032',0,1);
INSERT INTO course VALUES(83,'Đá cầu 1','PE6029',0,1);
INSERT INTO course VALUES(84,'Đá cầu 2','PE6030',0,1);
INSERT INTO course VALUES(85,'Karate 1','PE6011',0,1);
INSERT INTO course VALUES(86,'Karate 2','PE6012',0,1);
INSERT INTO course VALUES(87,'Khiêu vũ 1','PE6013',0,1);
INSERT INTO course VALUES(88,'Khiêu vũ 2','PE6014',0,1);
INSERT INTO course VALUES(89,'Pencak Silat 1','PE6015',0,1);
INSERT INTO course VALUES(90,'Pencak Silat 2','PE6016',0,1);
INSERT INTO course VALUES(91,'Tennis 1','PE6019',0,1);
INSERT INTO course VALUES(92,'Tennis 2','PE6020',0,1);
INSERT INTO course VALUES(93,'Cơ sở lập trình nhúng','IT6007',2,1);
INSERT INTO course VALUES(94,'Công cụ phát triển phần mềm','IT6003',2,1);
INSERT INTO course VALUES(95,'Đồ họa máy tính','IT6010',2,1);
INSERT INTO course VALUES(96,'Thiết kế giao diện người dùng','IT6037',2,1);
INSERT INTO course VALUES(97,'Ứng dụng thuật toán','IT6044',2,1);
INSERT INTO course VALUES(98,'Kỹ thuật số','IT6016',3,0);
INSERT INTO course VALUES(99,'Phương pháp số trong lập trình','IT6032',3,0);
INSERT INTO course VALUES(100,'Công nghệ đa phương tiện','IT6004',2,1);
INSERT INTO course VALUES(101,'Công nghệ thực tại ảo','IT6005',2,1);
INSERT INTO course VALUES(102,'Lập trình Java nâng cao','IT6020',2,1);
INSERT INTO course VALUES(103,'Lập trình Web bằng ASP.NET','IT6021',2,1);
INSERT INTO course VALUES(104,'Lập trình web bằng PHP','IT6022',2,1);
INSERT INTO course VALUES(105,'Phần mềm mã nguồn mở','IT6030',2,1);
INSERT INTO course VALUES(106,'Phát triển ứng dụng Game','IT6028',2,1);
INSERT INTO course VALUES(107,'Phát triển ứng dụng trên thiết bị di động','IT6029',2,1);
INSERT INTO course VALUES(108,'Tích hợp hệ thống phần mềm','IT6034',2,1);
INSERT INTO course VALUES(109,'Tư tưởng Hồ Chí Minh','120305',2,0);
INSERT INTO course VALUES(110,'Kinh tế học đại cương','110322',2,0);
INSERT INTO course VALUES(111,'Cơ sở lập trình nhúng','0503110',2,1);
INSERT INTO course VALUES(112,'Giáo dục thể chất 1','0904103',1,1);
INSERT INTO course VALUES(113,'Giáo dục thể chất 2','0904104',1,1);
INSERT INTO course VALUES(114,'Giáo dục thể chất 3','0904105',1,1);
INSERT INTO course VALUES(115,'Hệ quản trị cơ sở dữ liệu (SQL Server)','0503123',2,1);
INSERT INTO course VALUES(116,'Kinh tế học đại cương','1603113',2,0);
INSERT INTO course VALUES(117,'Nguyên lý hệ điều hành','0503140',2,0);
INSERT INTO course VALUES(118,'Nhập môn tin học','0503143',2,1);
INSERT INTO course VALUES(119,'Tư tưởng Hồ Chí Minh','1203108',2,0);
INSERT INTO course VALUES(120,'Xác suất thống kê','1003111',3,0);
INSERT INTO course VALUES(121,'Công nghệ đa phương tiện','0503168',2,1);
INSERT INTO course VALUES(122,'Phát triển ứng dụng Game','0503171',2,0);
INSERT INTO course VALUES(123,'Ứng dụng thuật toán','0503176',2,1);
INSERT INTO course VALUES(124,'Giáo dục thể chất 1.','0904111',0,1);
INSERT INTO course VALUES(125,'Giáo dục thể chất 2.','0904112',0,1);
INSERT INTO course VALUES(126,'Bóng chuyền 1','0904115',0,1);
INSERT INTO course VALUES(127,'Bóng chuyền 2','0904116',0,1);
INSERT INTO course VALUES(128,'Bóng chuyền 1','0903115',0,1);
INSERT INTO course VALUES(129,'Tiếng Anh Công nghệ thông tin cơ bản 1','1303190',2,0);
INSERT INTO course VALUES(130,'Cầu mây','PE6007',0,1);
INSERT INTO course VALUES(131,'Đá cầu','PE6008',0,1);
INSERT INTO course VALUES(132,'Ôn tập Tiếng Anh Công nghệ thông tin cơ bản 1','FL6085OT',1,0);
INSERT INTO course VALUES(133,'Ôn tập Tiếng Anh công nghệ thông tin cơ bản 2','FL6086OT',1,0);
INSERT INTO course VALUES(134,'Ôn tập Tiếng Anh Công nghệ thông tin cơ bản 3','FL6087OT',1,0);
INSERT INTO course VALUES(135,'Ôn tập Tiếng Anh Công nghệ thông tin cơ bản 4','FL6088OT',1,0);
INSERT INTO course VALUES(136,'Ôn tập Tiếng Anh Công nghệ thông tin cơ bản 5','FL6089OT',1,0);
INSERT INTO course VALUES(137,'Lập trình Web bằng PHP','0503184',2,1);
INSERT INTO course VALUES(138,'Kiến trúc máy tính.','0503188',3,0);
INSERT INTO course VALUES(139,'Nhập môn Công nghệ phần mềm.','0503200',3,0);
INSERT INTO course VALUES(140,'Quân sự chung','DC6006',1,0);
INSERT INTO course VALUES(141,'Kỹ thuật chiến đấu bộ binh và chiến thuật','DC6007',0,2);
INSERT INTO course VALUES(142,'Tiếng Hàn 1','FL6335',5,0);
INSERT INTO course VALUES(143,'Tiếng Hàn 2','FL6336',5,0);
INSERT INTO course VALUES(144,'Tiếng Nhật 1','FL6337',5,0);
INSERT INTO course VALUES(145,'Tiếng Nhật 2','FL6338',5,0);
INSERT INTO course VALUES(146,'Tiếng Trung 1','FL6339',5,0);
INSERT INTO course VALUES(147,'Tiếng Trung 2','FL6340',5,0);
INSERT INTO course VALUES(148,'Tiếng Anh Công nghệ thông tin 1','FL6343',5,0);
INSERT INTO course VALUES(149,'Tiếng Anh Công nghệ thông tin 2','FL6344',5,0);
INSERT INTO course VALUES(150,'Phát triển ứng dụng di động đơn nền tảng','IT6076',2,1);
INSERT INTO course VALUES(151,'Nhập môn công nghệ phần mềm ','IT6082',2,0);
INSERT INTO course VALUES(152,'Mạng máy tính ','IT6083',2,1);
INSERT INTO course VALUES(153,'Kiểm thử phần mềm ','IT6084',2,0);
INSERT INTO course VALUES(154,'Đảm bảo chất lượng phần mềm ','IT6085',2,0);
INSERT INTO course VALUES(155,'Trí tuệ nhân tạo','IT6094',2,1);
INSERT INTO course VALUES(156,'Tối ưu hóa','IT6095',2,1);
INSERT INTO course VALUES(157,'Thiết kế phần mềm','IT6096',2,0);
INSERT INTO course VALUES(158,'Phân tích và đặc tả yêu cầu phần mềm','IT6097',2,0);
CREATE TABLE lectures
(

    id        INTEGER PRIMARY KEY,

    course_id INTEGER NOT NULL,

    name      TEXT

);

INSERT INTO lectures (id, course_id, name) VALUES (1, 150, 'Lecture 1 - Android Introduction');
INSERT INTO lectures (id, course_id, name) VALUES (2, 150, 'Lecture 2 - Android Activity');

CREATE TABLE lessons

(

    id         INTEGER PRIMARY KEY,

    lecture_id INTEGER NOT NULL

);

INSERT INTO lessons (id, lecture_id) VALUES (1, 1);
INSERT INTO lessons (id, lecture_id) VALUES (2, 1);
INSERT INTO lessons (id, lecture_id) VALUES (3, 2);
INSERT INTO lessons (id, lecture_id) VALUES (4, 2);

CREATE TABLE quizzes

(

    id        INTEGER PRIMARY KEY,

    lesson_id INTEGER NOT NULL,

    name      TEXT,

    question  TEXT,

    answers   TEXT

);

INSERT INTO quizzes (id, lesson_id, name, question, answers) values (1, 2, 'Android Activity', 'Một thành phần cơ bản của ứng dụng Android, đại diện cho một màn hình giao diện người dùng.', 'activity');
INSERT INTO quizzes (id, lesson_id, name, question, answers) values (2, 4, 'Android Recycle View', 'Một thành phần để hiển thị danh sách dữ liệu lặp lại trong ứng dụng Android.', 'list view');

CREATE TABLE articles

(

    id        INTEGER PRIMARY KEY,

    lesson_id INTEGER NOT NULL,

    name      TEXT,

    content   TEXT

);

INSERT INTO articles VALUES(1,1, 'Android activity','<h1>Tìm hiểu về Activity và vòng đời Activity</h1> <h2>Giới thiệu về Activity trong Android</h2> <p>Lớp Activity là thành phần quan trọng nhất của ứng dụng Android, cách mà chúng hoạt động tạo thành nền tảng cơ bản của mô hình lập trình ứng dụng. Android khởi chạy một ứng dụng thông thường bằng kích hoạt một Activity tương ứng với vòng đời cụ thể của nó trong quá trình hoạt động.</p> <p>Thường một Activity cung cấp một của sổ, ở đó ứng dụng sẽ dựng các thành phần UI (User Interface - giao diện người dùng). Mặc định cửa sổ này là đầy màn hình thiết bị, nhưng có một vài trường hợp riêng sẽ nhỏ hơn và nổi phía trên cửa sổ khác.</p> <p>Hầu hết các ứng dụng đều sử dụng nhiều màn hình khác nhau, có nghĩa nó sẽ phải có nhiều Activity khác nhau. Khi một Activity chỉ định là Activity chính, nó sẽ là màn hình đầu tiên khi khởi chạy ứng dụng. Một Activity này lại có thể gọi và kích hoạt một Activity khác. Ví dụ một Activity hiện thị danh sách các ghi chú, nó gọi một Activity khác để xem nội dung chi tiết của ghi chú.</p> <h2>Activty</h2> <p>Xem hình trên, ứng dụng khởi chạy với Activity - A, Activity - A kích hoạt Activity - B bằng Intent, Activity - B hoạt động có thể gọi Activity - C và khi bấm nút Back của điện thoạt Activity được gọi sẽ đóng và trở này Activity gọi nó</p>');
INSERT INTO articles VALUES(2,3, 'Android recycle view','<h1>Tìm hiểu về RecyclerView trong Android</h1> <h2>Giới thiệu về RecyclerView</h2> <p>RecyclerView là một thành phần quan trọng trong Android để hiển thị danh sách dữ liệu có thể cuộn. Nó là một cải tiến so với ListView truyền thống vì cung cấp khả năng linh hoạt hơn trong việc tạo giao diện danh sách phức tạp và quản lý dữ liệu hiệu quả hơn.</p> <p>RecyclerView sử dụng mô hình ViewHolder để tái sử dụng các phần tử giao diện đã được tạo. Điều này giúp tối ưu hóa hiệu suất bằng cách chỉ cập nhật và vẽ lại các phần tử hiển thị thực sự trên màn hình.</p> <h2>RecyclerView</h2> <p>Xem hình trên, RecyclerView được sử dụng để hiển thị danh sách dữ liệu. Các phần tử giao diện trong danh sách được tạo và quản lý thông qua các ViewHolder. Các phần tử này có thể tái sử dụng khi cần thiết, giúp tối ưu hóa hiệu suất.</p> <h2>Vòng đời một RecyclerView</h2> <p>RecyclerView không có vòng đời riêng như Activity, nhưng nó được quản lý thông qua các Adapter và LayoutManager.</p> <p>Adapter là một lớp dùng để cung cấp dữ liệu cho RecyclerView. Nó đóng vai trò là cầu nối giữa dữ liệu và giao diện hiển thị. Khi dữ liệu thay đổi, Adapter sẽ thông báo cho RecyclerView để cập nhật giao diện.</p> <p>LayoutManager là một lớp quyết định cách các phần tử giao diện trong RecyclerView được sắp xếp và hiển thị trên màn hình. Nó xác định kiểu hiển thị của RecyclerView, chẳng hạn như danh sách dọc, danh sách ngang, lưới, v.v.</p> <p>Vòng đời của RecyclerView phụ thuộc vào vòng đời của Adapter và LayoutManager. Khi dữ liệu thay đổi, Adapter sẽ thông báo cho RecyclerView và yêu cầu cập nhật giao diện. LayoutManager sau đó sẽ xác định các phần tử giao diện cần được hiển thị và cập nhật giao diện.</p> <p>Bạn có thể tuỳ chỉnh Adapter và LayoutManager theo nhu cầu của mình để tạo giao diện danh sách phức tạp và xử lý dữ liệu theo cách mong muốn.</p>');

CREATE TABLE class_instructors

(

    id            INTEGER PRIMARY KEY,

    instructor_id INTEGER NOT NULL,

    class_id      INTEGER NOT NULL

);
CREATE TABLE enrollments (

    id INTEGER PRIMARY KEY,

    user_id INTEGER NOT NULL,

    class_id INTEGER NOT NULL,

    debt INTEGER,

    enrolled_date TEXT,

    end_date TEXT,

    debt_paid_date TEXT

, regular_score TEXT, progress_score TEXT, exam_score TEXT);
INSERT INTO enrollments VALUES(1,1,4,2500000,'2023-05-05 16:43:58','2023-07-20 19:43:58','2023-09-12 19:43:58',1,2,3);
INSERT INTO enrollments VALUES(2,1,2,2500000,'2023-05-05 16:43:58','2023-07-05 19:43:58','2023-06-05 19:43:58',3,4,5);
INSERT INTO enrollments VALUES(3,4,9,1200000,'2023-05-10 10:25:17','2023-08-10 15:40:52','2023-06-10 15:40:52',4,5,6);
INSERT INTO enrollments VALUES(4,1,3,2500000,'2023-05-05 16:43:58','2023-07-05 19:43:58',NULL,3,4,5);
INSERT INTO enrollments VALUES(5,4,9,1200000,'2023-05-10 10:25:17','2023-09-10 15:40:52','2023-06-10 15:40:52',4,5,6);
INSERT INTO enrollments VALUES(6,2,3,800000,'2023-05-11 12:55:30','2023-06-11 18:20:15','2023-06-11 18:20:15',7,8,9);
INSERT INTO enrollments VALUES(7,5,1,500000,'2023-05-12 14:45:22','2023-06-13 09:35:40','2023-06-13 09:35:40',10,1,2);
INSERT INTO enrollments VALUES(8,3,5,0,'2023-06-14 16:10:05','2023-07-15 10:55:27','2023-06-15 10:55:27',3,4,5);
INSERT INTO enrollments VALUES(9,1,7,1500000,'2023-06-16 18:20:41','2023-07-16 23:05:13',NULL,6,7,8);
INSERT INTO enrollments VALUES(10,4,6,900000,'2023-06-17 20:30:12','2023-07-18 09:15:29','2023-06-18 09:15:29',9,10,1);
INSERT INTO enrollments VALUES(11,2,8,600000,'2023-06-19 22:40:09','2023-07-20 16:30:50','2023-06-20 16:30:50',2,3,4);
INSERT INTO enrollments VALUES(12,5,4,2000000,'2023-06-1 09:50:35','2023-07-21 15:55:20','2023-06-21 15:55:20',5,6,7);
INSERT INTO enrollments VALUES(13,3,2,1800000,'2023-06-2 11:15:48','2023-07-23 08:10:37','2023-06-23 08:10:37',8,9,10);
INSERT INTO enrollments VALUES(14,2,3,800000,'2023-06-24 13:30:57','2023-07-24 17:45:59','2023-06-24 17:45:59',4,7,9);
CREATE TABLE classes

(

    id          INTEGER PRIMARY KEY,

    course_id   INTEGER NOT NULL,

    class_code  TEXT,

    day_in_week TEXT,

    time_in_day TEXT,

    room        TEXT

);
INSERT INTO classes VALUES(1,45,'20222IT6076001','1','1,2,3','307 - A');
INSERT INTO classes VALUES(2,87,'20222IT6076002','1,4','2,3,4','404 - B');
INSERT INTO classes VALUES(3,113,'20222IT6076003','2','3,4,5','208 - A');
INSERT INTO classes VALUES(4,150,'20222IT6076004','2,3','4,5,6','512 - C');
INSERT INTO classes VALUES(5,157,'20222IT6076005','3','5,6,7','601 - A');
INSERT INTO classes VALUES(6,92,'20222IT6076006','3,6','6,7,8','303 - C');
INSERT INTO classes VALUES(7,6,'20222IT6076007','4','7,8,9','105 - A');
INSERT INTO classes VALUES(8,134,'20222IT6076008','4,5','8,9,10','411 - B');
INSERT INTO classes VALUES(9,53,'20222IT6076009','4,6','9,10,11','202 - C');
INSERT INTO classes VALUES(10,71,'20222IT6076010','5','10,11,12','406 - A');
INSERT INTO classes VALUES(11,129,'20222IT6076011','5,6','11,12,13','704 - B');
INSERT INTO classes VALUES(12,41,'20222IT6076012','5,7','1,2,3,4','301 - C');
INSERT INTO classes VALUES(13,98,'20222IT6076013','6','2,3,4,5','503 - B');
INSERT INTO classes VALUES(14,11,'20222IT6076014','6,7','3,4,5,6','201 - A');
INSERT INTO classes VALUES(15,76,'20222IT6076015','7','4,5,6,7','407 - C');
INSERT INTO classes VALUES(16,142,'20222IT6076016','1','5,6,7,8','103 - B');
INSERT INTO classes VALUES(17,33,'20222IT6076017','1,2','6,7,8,9','606 - A');
INSERT INTO classes VALUES(18,59,'20222IT6076018','1,3','7,8,9,10','401 - C');
INSERT INTO classes VALUES(19,121,'20222IT6076019','1,4','8,9,10,11','702 - A');
CREATE TABLE notifications

(

    id         INTEGER PRIMARY KEY,

    content    TEXT,

    type       TEXT,

    created_at TEXT

);
INSERT INTO notifications VALUES(1, 'Khảo Sát Sinh Viên Về Hoạt Động Giảng Dạy','Khảo sát','2023-06-14 14:35:00');
INSERT INTO notifications VALUES(2, 'Phiếu Khảo Sát Thông Tin Phục Vụ Công Tác Phòng Chống Dịch Bệnh Covid 19', 'Khảo sát', '2023-06-14 14:40:00');
INSERT INTO notifications VALUES(3, 'Update application', 'Update', '2023-06-14 15:00:00');
INSERT INTO notifications VALUES(4, 'Thank for Login', 'Event', '2023-06-14 17:15:00');
INSERT INTO notifications VALUES(5, 'You will have class tomorrow', 'Reminder', '2023-06-14 18:00:00');
INSERT INTO notifications VALUES(6, 'Your application was updated', 'Update', '2023-06-15 09:00:00');
CREATE TABLE user_notifications(

    id INTEGER PRIMARY KEY,

    user_id INTEGER NOT NULL,

    notification_id INTEGER NOT NULL,

    created_at TEXT

);

INSERT INTO user_notifications VALUES (1, 1, 1, '2023-06-14 14:35:00');
INSERT INTO user_notifications VALUES (2, 1, 2, '2023-06-14 14:40:00');
INSERT INTO user_notifications VALUES (3, 2, 1, '2023-06-14 15:00:00');
INSERT INTO user_notifications VALUES (4, 3, 1, '2023-06-14 17:15:00');
INSERT INTO user_notifications VALUES (5, 1, 3, '2023-06-14 18:00:00');
INSERT INTO user_notifications VALUES (6, 2, 5, '2023-06-15 09:00:00');
