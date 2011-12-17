import com.entagen.bbex.User

class BootStrap {

    def init = { servletContext ->
        new User(firstName: 'Matt', lastName: 'Sheehan', email: 'matt.sheehan@entagen.com').save()
        new User(firstName: 'Mike', lastName: 'Hugo', email: 'mike@entagen.com').save()
        new User(firstName: 'Ola', lastName: 'Bildtsen', email: 'ola@entagen.com').save()
        new User(firstName: 'Chris', lastName: 'Bouton', email: 'chris@entagen.com').save()
        new User(firstName: 'Erik', lastName: 'Bakke', email: 'erik.bakke@entagen.com').save()
        new User(firstName: 'Amy', lastName: 'Andrychowicz', email: 'amy@entagen.com').save()
        new User(firstName: 'Joe', lastName: 'Hoover', email: 'joe.hoover@entagen.com').save()
        new User(firstName: 'Bill', lastName: 'Schuler', email: 'bill.schuler@entagen.com').save()
        new User(firstName: 'Franz', lastName: 'Lawaetz', email: 'frans.lawaetz@entagen.com').save()
        new User(firstName: 'Nguyen', lastName: 'Nguyen', email: 'nguyen@entagen.com').save()
        new User(firstName: 'Valerie', lastName: 'Meyer', email: 'valerie.meyer@entagen.com').save()
    }
    def destroy = {
    }
}
