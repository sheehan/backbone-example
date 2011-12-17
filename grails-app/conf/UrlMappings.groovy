import org.codehaus.groovy.grails.commons.GrailsDomainClass
import com.entagen.bbex.User

class UrlMappings {

    static mappings = {
        def root = '/api'

        "${root}/user"(controller: 'jsonRestApi') {
            entity = User.class.name
            action = [GET: 'list', POST: 'create']
        }

        "${root}/user/$id"(controller: 'jsonRestApi') {
            entity = User.class.name
            action = [GET: 'show', PUT: 'update', DELETE: 'delete']
        }

        "/$controller/$action?/$id?" {
            constraints {
                // apply constraints here
            }
        }

        "/"(view: "/index")
        "500"(view: '/error')


    }
}
